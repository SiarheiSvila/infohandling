package com.epam.infohandling.action.sort;

import com.epam.infohandling.action.ComponentCopier;
import com.epam.infohandling.entity.Component;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;

public class SymbolQuantitySorter implements ComponentSorter {

    private char symbol;

    public SymbolQuantitySorter(char symbol){
        this.symbol = symbol;
    }

    @Override
    public Component sortComponent(Component component) {
        if (component == null) {
            throw new IllegalArgumentException("it is not allow for null component in the SymbolQuantitySorter class,sortComponent method");
        }

        Component composite = ComponentCopier.copyComponent(component);
        List<Component> paragraphs = composite.getChildren();
        paragraphs.sort(new Comparator<Component>() {
            @Override
            public int compare(Component firstLexeme, Component secondLexeme) {

                String firstLexemeValue = firstLexeme.getValue();
                String secondLexemeValue = secondLexeme.getValue();

                int firstSymbolOccurrenceCounter =
                        StringUtils.countMatches(firstLexemeValue, String.valueOf(symbol));
                int secondSymbolOccurrenceCounter =
                        StringUtils.countMatches(secondLexemeValue, String.valueOf(symbol));

                if (firstSymbolOccurrenceCounter != secondSymbolOccurrenceCounter) {
                    return  firstSymbolOccurrenceCounter - secondSymbolOccurrenceCounter;
                }

                return secondLexemeValue.compareToIgnoreCase(firstLexemeValue);
            }
        });
        return composite;
    }
}
