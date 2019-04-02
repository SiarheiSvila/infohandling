package com.epam.infohandling.parser;

public abstract class AbstractParser implements Parser {

    private Parser successor;


    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }
}
