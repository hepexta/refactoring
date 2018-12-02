package com.hepexta.refactoring.patternshappy.factory;

import com.hepexta.refactoring.patternshappy.message.MessageBody;
import com.hepexta.refactoring.patternshappy.message.MessageStrategy;

public class DefaultFactory extends AbstractStrategyFactory {
    private DefaultFactory() {
    }
    private static DefaultFactory instance;
    public static AbstractStrategyFactory getInstance() {
        if (instance == null)
            instance = new DefaultFactory();
        return instance;
    }

    public MessageStrategy createStrategy(final MessageBody mb) {
        return new MessageStrategy() {
            MessageBody body = mb;
            public void sendMessage() {
                Object obj = body.getPayload();
                System.out.println(obj);
            }
        };
    }
}
