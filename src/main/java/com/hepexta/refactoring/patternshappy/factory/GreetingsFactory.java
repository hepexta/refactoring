package com.hepexta.refactoring.patternshappy.factory;

import com.hepexta.refactoring.patternshappy.message.MessageBody;
import com.hepexta.refactoring.patternshappy.message.MessageStrategy;

public class GreetingsFactory extends AbstractStrategyFactory {
    private GreetingsFactory() {
    }
    private static GreetingsFactory instance;
    public static AbstractStrategyFactory getInstance() {
        if (instance == null)
            instance = new GreetingsFactory();
        return instance;
    }

    public MessageStrategy createStrategy(final MessageBody mb) {
        return new MessageStrategy() {
            MessageBody body = mb;
            public void sendMessage() {
                Object obj = body.getPayload();
                System.out.println(obj+" And Greetings!");
            }
        };
    }
}
