package com.epam.infohandling.mathinterpreter;

import com.epam.infohandling.mathinterpreter.operation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionCalculator {
    private List<MathOperation> mathOperation;

    public ExpressionCalculator(String expression) {
        mathOperation = new ArrayList<>();
        operationParser(expression);
    }


    private void operationParser(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("Expression is null in ExpressionCalculator");
        }
        for (String operation : expression.split(" ")) {
            if (operation.isEmpty()) {
                continue;
            }

            switch (operation) {
                case "+":
                    mathOperation.add(new Addition());
                    break;
                case "-":
                    mathOperation.add(new Subtraction());
                    break;
                case "*":
                    mathOperation.add(new Multiplication());
                    break;
                case "/":
                    mathOperation.add(new Division());
                    break;
                default:
                    Scanner scanner = new Scanner(operation);
                    if(scanner.hasNextInt()){
                        mathOperation.add(new NonTerminalOperation(scanner.nextInt()));
                    }
                    break;
            }
        }
    }

    public int calculate() {
        ValueStack valueStack = new ValueStack();
        for (MathOperation mathOperation : mathOperation) {
            mathOperation.interpret(valueStack);
        }
        return valueStack.popValue();
    }
}
