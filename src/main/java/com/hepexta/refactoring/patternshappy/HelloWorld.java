package com.hepexta.refactoring.patternshappy;

import com.hepexta.refactoring.patternshappy.factory.AbstractStrategyFactory;
import com.hepexta.refactoring.patternshappy.factory.DefaultFactory;
import com.hepexta.refactoring.patternshappy.factory.GreetingsFactory;
import com.hepexta.refactoring.patternshappy.message.MessageBody;
import com.hepexta.refactoring.patternshappy.message.MessageStrategy;

public class HelloWorld {
    public static void main(String[] args) {
        MessageBody mb = new MessageBody();
        mb.configure("Hello World!");
        mb.send(getDefaultStrategy(mb));
        mb.send(getGreetingsStrategy(mb));
    }

    private static MessageStrategy getDefaultStrategy(MessageBody mb) {
        AbstractStrategyFactory asf = DefaultFactory.getInstance();
        return asf.createStrategy(mb);
    }

    private static MessageStrategy getGreetingsStrategy(MessageBody mb) {
        AbstractStrategyFactory asf = GreetingsFactory.getInstance();
        return asf.createStrategy(mb);
    }
}
