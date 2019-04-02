package com.epam.infohandling.mathinterpreter;

import java.util.ArrayDeque;

public class ValueStack {
    private ArrayDeque<Integer> value = new ArrayDeque<>();

    public void pushValue(Integer number){
        if (number == null) {
            throw new IllegalArgumentException("Number is not allow to be null in ValueStack class, add method");
        }
        value.push(number);
    }

    public Integer popValue(){
        return value.pop();
    }
}
