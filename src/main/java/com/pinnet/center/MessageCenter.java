package com.pinnet.center;

import com.pinnet.observable.MessageObservable;
import com.pinnet.observer.impl.PUBMessageListener;
import com.pinnet.observer.impl.SUBMessageListener;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageCenter {

    //保存的类型和被观察者
    private static Map<MessageType, MessageObservable> messageMap = new ConcurrentHashMap<MessageType, MessageObservable>();

    //获取被观察者
    public static MessageObservable getObservable(MessageType messageType) {
        //如果被观察者存在，直接使用
        if (messageMap.containsKey(messageType)) {
            return messageMap.get(messageType);
        } else {
            //或者新增一个被观察者
            MessageObservable abstractServable = new MessageObservable();
            messageMap.put(messageType, abstractServable);
            return abstractServable;
        }
    }

    //发送数据
    public static void sendMessage(MessageType messageType, Serializable serializable){
        if (messageMap.containsKey(messageType)) {
            try {
                //获取被观察者，然后发送数据
                MessageObservable messageObservable = messageMap.get(messageType);
                //相关数据
                ObjectMessage objectMessage = new ActiveMQObjectMessage();
                objectMessage.setObject(serializable);
                messageObservable.sendMessage(objectMessage);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    //枚举更好管理
    public enum MessageType {
        PUB,SUB
    }

    //注册被观察者
    public static void init() {
        new PUBMessageListener(MessageCenter.getObservable(MessageType.PUB));
        new PUBMessageListener(MessageCenter.getObservable(MessageType.PUB));
        new SUBMessageListener(MessageCenter.getObservable(MessageType.SUB));
    }
}
