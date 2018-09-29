package com.pinnet.observer.impl;

import com.pinnet.observable.MessageObservable;
import com.pinnet.observer.MessageObserver;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

//监听类
public class PUBMessageListener extends MessageObserver {

    public PUBMessageListener(MessageObservable messageObservable) {
        super(messageObservable);
    }

    //接收数据
    public void onMessage(ObjectMessage objectMessage) {
        try {
            System.out.println(objectMessage.getObject());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
