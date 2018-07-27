package com.kuliashou.information.action;

import com.kuliashou.information.composite.Component;
import com.kuliashou.information.composite.Composite;
import com.kuliashou.information.composite.PartType;
import com.kuliashou.information.exception.TextReaderException;
import com.kuliashou.information.parser.TextParser;
import com.kuliashou.information.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextActionTest {

    @Test
    public void testSortParagraphsByLengthOfSentences() throws TextReaderException {

        //Given
        String expected = "    Consumers learn to generalize from what they have learned." +
                "    If advertisements are to he learned, there is a need for lots of repetition." +
                " You see people looking cool and relaxed." +
                "    Advertisements want to persuade us to buy particular products." +
                " How do they do it. You feel thirsty.";

        //When
        String text = TextReader.readText("data/test.txt");
        Component composite = new Composite(PartType.TEXT);
        TextParser textParser = new TextParser();

        textParser.parse(composite, text);
        composite = textParser.getTextComposite();
        Component sortParagraphsByLengthOfSentences = TextAction.sortParagraphsByLengthOfSentences(composite);
        String actual = sortParagraphsByLengthOfSentences.toString();

        //Then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortSentencesByLengthOfLexemes() throws TextReaderException {

        //Given
        String expected = "    to us to buy want persuade products. particular Advertisements do do How it." +
                " they You feel thirsty." +
                "    a If to he is of are for need lots there learned, repetition. advertisements You see and cool" +
                " people looking relaxed." +
                "    to from what they have learn learned. Consumers generalize";

        //When
        String text = TextReader.readText("data/test.txt");
        Component composite = new Composite(PartType.TEXT);
        TextParser textParser = new TextParser();

        textParser.parse(composite, text);
        composite = textParser.getTextComposite();
        Component sortSentencesByLengthOfLexemes = TextAction.sortSentencesByLengthOfLexemes(composite);
        String actual = sortSentencesByLengthOfLexemes.toString();

        //Then
        Assert.assertEquals(actual, expected);
    }
}