package com.pinnet;

import com.pinnet.center.MessageCenter;

public class Main {
    public static void main(String[] args) {
        MessageCenter.init();
        MessageCenter.sendMessage(MessageCenter.MessageType.PUB, "pub");
        MessageCenter.sendMessage(MessageCenter.MessageType.SUB, "sub");
    }
}
