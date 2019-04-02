package com.epam.infohandling.action;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Lexeme;

public class ComponentBuilder {

    public Component component() {
        Component component = new Composite();
        Component lexeme;
        lexeme = Lexeme.word("word");
        component.add(lexeme);
        lexeme = Lexeme.word("second");
        component.add(lexeme);
        lexeme = Lexeme.word("third");
        component.add(lexeme);
        lexeme = Lexeme.expression("22 8 + 6 * 5 -");
        component.add(lexeme);
        return component;
    }

    public Component build(String text, String text1, String text3, String expre1){

        Component component = new Composite();
        Component lexeme;
        lexeme = Lexeme.word(text);
        component.add(lexeme);
        lexeme = Lexeme.word(text1);
        component.add(lexeme);
        lexeme = Lexeme.word(text3);
        component.add(lexeme);
        lexeme = Lexeme.expression(expre1);
        component.add(lexeme);
        return component;
    }
}
