package com.epam.infohandling.mathinterpreter.operation;

import com.epam.infohandling.mathinterpreter.ValueStack;

public class NonTerminalOperation implements MathOperation {
    private int number;

    public NonTerminalOperation(int number) {
        this.number = number;
    }

    @Override
    public void interpret(ValueStack valueStack) {
        if (valueStack == null) {
            throw new IllegalArgumentException("It is not allowed for a null value for the value stack in NonTerminalOperation class");
        }
        valueStack.pushValue(number);
    }
}
