package com.epam.infohandling.mathinterpreter.operation;

import com.epam.infohandling.mathinterpreter.ValueStack;

public class Division implements MathOperation {

    @Override
    public void interpret(ValueStack valueStack) {
        if (valueStack == null) {
            throw new IllegalArgumentException("Not allow for a null value for the value stack in Division class");
        }
        Integer firstValue = valueStack.popValue();
        Integer secondValue = valueStack.popValue();
        valueStack.pushValue(secondValue / firstValue);
    }
}
