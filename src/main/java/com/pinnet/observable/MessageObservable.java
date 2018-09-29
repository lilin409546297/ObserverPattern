package com.pinnet.observable;

import javax.jms.ObjectMessage;
import java.util.Observable;

//被观察者
public class MessageObservable extends Observable {

    //发送数据
    public void sendMessage(ObjectMessage objectMessage) {
        //设置改变提醒观察者（必须）
        setChanged();
        //传输给观察者
        notifyObservers(objectMessage);
    }
}
