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

    @BeforeClass
    public void setUp() {
        textParser = new TextParser();
        textComposite = new Composite(PartType.TEXT);
    }

    @AfterClass
    public void tearDown() {
        textParser = null;
        textComposite = null;
    }

    @Test
    public void testComposite() {

        //Given
        String expected = "    Advertisements want to persuade us to buy " +
                "particular products. How do they do it. You feel thirsty." +
                "    If advertisements are to he learned, there is a need for " +
                "lots of repetition. You see people looking cool and relaxed." +
                "    Consumers learn to generalize from what they " +
                "have learned.";
        String actual = null;

        //When
        try {
            String text = TextReader.readText("data/test.txt");
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