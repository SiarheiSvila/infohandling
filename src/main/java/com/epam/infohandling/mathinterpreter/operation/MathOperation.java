package com.epam.infohandling.mathinterpreter.operation;

import com.epam.infohandling.mathinterpreter.ValueStack;

public interface MathOperation {
    void interpret(ValueStack valueStack);
}
