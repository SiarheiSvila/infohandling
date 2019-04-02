package com.epam.infohandling.parser;

import com.epam.infohandling.action.ComponentBuilder;
import com.epam.infohandling.entity.Component;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FullParserTest {
    private static Parser parser;
    private static ComponentBuilder componentBuilder;
    private static String text;

    @BeforeClass
    public static void init(){
        parser = new FullParser();
        componentBuilder = new ComponentBuilder();
        text = "It was popularised 2 4 + 6 * 2 / 3 -";
    }

    @Test
    public void parseTest(){
        Component actualComponent = parser.parse(text);
        Component expectedComponent = componentBuilder.build("It", "was", "popularised", "15");

        Assert.assertEquals(expectedComponent, actualComponent);
    }
}
