package com.kuliashou.information.reader;

import com.kuliashou.information.exception.TextReaderException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextReaderTest {

    @Test
    public void testTextReader() throws TextReaderException {
        //Given
        String expected = "    Advertisements want to persuade us to buy\n" +
                "particular products. How do they do it. You feel thirsty.\n" +
                "    If advertisements are to he learned, there is a need for\n" +
                "lots of repetition. You see people looking cool and relaxed.\n" +
                "    Consumers learn to generalize from what they\n" +
                "have learned.\n";

        //When
        String actual = TextReader.readText("data/test.txt");

        //Then
        Assert.assertEquals(actual, expected);
    }
}