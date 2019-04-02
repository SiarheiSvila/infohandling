package com.epam.infohandling.action.sort;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Lexeme;
import com.epam.infohandling.util.InfoRegex;

import java.util.Comparator;
import java.util.List;

public class SentenceLengthSorter implements ComponentSorter {

    @Override
    public Component sortComponent(Component component) {
        if (component == null) {
            throw new IllegalArgumentException("it is not allow for null component in the SentenceLengthSorter class,sortComponent method");
        }

        Component composite = buildSentence(component);
        List<Component> componentList = composite.getChildren();
        componentList.sort(new Comparator<Component>() {
            @Override
            public int compare(Component o1, Component o2) {
                return o1.getValue().length() - o2.getValue().length();
            }
        });
        return composite;
    }

    private Component buildSentence(Component component){
        if (component == null) {
            throw new IllegalArgumentException("it is not allow for null component in the SentenceLengthSorter class, buildSentence method");
        }

        Component composite = new Composite();
        String text = component.getValue();
        for(String sentence : text.split(InfoRegex.SENTENCE_TERMINATOR)){
            Component lexemeSentence = Lexeme.sentence(sentence);
            composite.add(lexemeSentence);
        }
        return composite;
    }

}
