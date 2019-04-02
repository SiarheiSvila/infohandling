package com.epam.infohandling.action;

import com.epam.infohandling.entity.Component;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComponentCopierTest {

    private static ComponentBuilder componentBuilder;
    private static Component oldComponent;
    private static Component newComponent;

    @BeforeClass
    public static void init() {
        componentBuilder = new ComponentBuilder();
        oldComponent = componentBuilder.component();
        newComponent = ComponentCopier.copyComponent(oldComponent);
    }

    @Test
    public void copyComponentTest() {
        Assert.assertEquals(newComponent, oldComponent);
    }

}
