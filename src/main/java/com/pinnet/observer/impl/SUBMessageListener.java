package com.pinnet.observer.impl;

import com.pinnet.observable.MessageObservable;
import com.pinnet.observer.MessageObserver;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

//监听者
public class SUBMessageListener extends MessageObserver{

    public SUBMessageListener(MessageObservable messageObservable) {
        super(messageObservable);
    }

    //接收消息
    public void onMessage(ObjectMessage objectMessage) {
        try {
            System.out.println(objectMessage.getObject());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
