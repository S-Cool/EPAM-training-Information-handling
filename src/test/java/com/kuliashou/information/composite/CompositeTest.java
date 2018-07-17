package com.kuliashou.information.composite;

import com.kuliashou.information.exception.TextReaderException;
import com.kuliashou.information.parser.TextParser;
import com.kuliashou.information.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeTest {

    private TextParser textParser;
    private Component textComposite;
    private String text;

    @BeforeClass
    public void setUp() {
        textParser = new TextParser();
        textComposite = new Composite(PartType.TEXT);
    }

    @AfterClass
    public void tearDown() {
        textParser = null;
        textComposite = null;
        text = null;
    }

    @Test
    public void TextTest() {

        //Given
        String expected = "    Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        String actual = null;

        //When
        try {
            text = TextReader.readText("data/testComposite.txt");
            textParser.parse(textComposite, text);
            textComposite = textParser.getTextComposite();
            actual = textComposite.toString();
        } catch (TextReaderException e) {
            fail();
        }

        //Then
        Assert.assertEquals(actual, expected);
    }
}