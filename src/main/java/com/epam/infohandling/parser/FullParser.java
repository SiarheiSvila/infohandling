package com.epam.infohandling.parser;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Lexeme;
import com.epam.infohandling.mathinterpreter.ExpressionCalculator;
import com.epam.infohandling.util.InfoMatcher;
import com.epam.infohandling.util.InfoRegex;

import java.util.regex.Matcher;

public class FullParser extends AbstractParser {

    @Override
    public Component parse(String text) {
        if (text == null) {
            throw new IllegalArgumentException("It's not allow for a null or empty text in FullParser class");
        }

        Component component = new Composite();
        Component lexemeComponent = new Composite();

        for (String paragraph : text.split(InfoRegex.PARAGRAPH_PATTERN)) {

            for (String sentence : paragraph.split(InfoRegex.SENTENCE_TERMINATOR)) {
                Matcher lexemeMatcher = InfoMatcher.matches(InfoRegex.LEXEME_PATTERN, sentence);
                while (lexemeMatcher.find()) {

                    String lexeme = lexemeMatcher.group();
                    if (lexeme.matches(InfoRegex.WORD_PATTERN)) {
                        lexemeComponent = Lexeme.word(lexeme);
                    } else if (lexeme.matches(InfoRegex.EXPRESSION_PATTERN)) {
                        ExpressionCalculator expressionCalculator = new ExpressionCalculator(lexeme);
                        lexemeComponent = Lexeme.expression(String.valueOf(expressionCalculator.calculate()));

                    }
                    component.add(lexemeComponent);
                }
            }

        }
        return component;
    }
}
