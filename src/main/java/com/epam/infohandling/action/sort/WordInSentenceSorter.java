package com.epam.infohandling.action.sort;

import com.epam.infohandling.action.ComponentCopier;
import com.epam.infohandling.entity.Component;

import java.util.Comparator;
import java.util.List;

public class WordInSentenceSorter implements ComponentSorter {

    @Override
    public Component sortComponent(Component component) {
        if (component == null) {
            throw new IllegalArgumentException("it is not allow for null component in the WordInSentenceSorter class,sortComponent method");
        }
        Component composite = ComponentCopier.copyComponent(component);
        List<Component> paragraph = composite.getChildren();

        paragraph.sort(new Comparator<Component>() {
            @Override
            public int compare(Component o1, Component o2) {
                return o1.getValue().length() - o2.getValue().length();
            }
        });
        return composite;
    }
}
