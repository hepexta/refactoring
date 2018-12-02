package com.hepexta.refactoring.patternshappy.factory;

import com.hepexta.refactoring.patternshappy.message.MessageBody;
import com.hepexta.refactoring.patternshappy.message.MessageStrategy;

public abstract class AbstractStrategyFactory {
    public abstract MessageStrategy createStrategy(MessageBody mb);
}
