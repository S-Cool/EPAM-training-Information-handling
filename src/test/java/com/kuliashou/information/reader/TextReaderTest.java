package com.kuliashou.information.reader;

import com.kuliashou.information.exception.TextReaderException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextReaderTest {

    @Test
    public void testTextReader() throws TextReaderException {
        //Given
        String expected = "    Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n";

        //When
        String actual = TextReader.readText("data/testComposite.txt");

        //Then
        Assert.assertEquals(actual, expected);
    }
}