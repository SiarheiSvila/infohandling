package com.epam.infohandling.action;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Composite;

import java.util.List;


public class ComponentCopier {

    public static Component copyComponent(Component component){
        if (component == null) {
            throw new IllegalArgumentException("It is not allowed for a null component in ComponentCopier class");
        }

        List<Component> componentList = component.getChildren();
        Component composite = new Composite();
        for (Component comp : componentList){
            composite.add(comp);
        }
        return composite;
    }
}
