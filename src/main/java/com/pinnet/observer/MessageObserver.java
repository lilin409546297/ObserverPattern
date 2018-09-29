package com.pinnet.observer;

import com.pinnet.observable.MessageObservable;

import javax.jms.ObjectMessage;
import java.util.Observable;
import java.util.Observer;

//观察者
public abstract class MessageObserver implements Observer {

    public MessageObserver(MessageObservable messageObservable) {
        if (messageObservable == null) {
            return;
        }
        //被观察者添加观察者
        messageObservable.addObserver(this);
    }

    //接收数据
    public void update(Observable observable, Object object) {
        ObjectMessage objectMessage = (ObjectMessage) object;
        onMessage(objectMessage);
    }

    //提供子类处理
    public abstract void onMessage(ObjectMessage objectMessage);
}
