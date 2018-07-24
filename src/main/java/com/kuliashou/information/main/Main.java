package com.kuliashou.information.main;

import com.kuliashou.information.action.TextAction;
import com.kuliashou.information.composite.Component;
import com.kuliashou.information.composite.Composite;
import com.kuliashou.information.composite.PartType;
import com.kuliashou.information.exception.TextReaderException;
import com.kuliashou.information.parser.TextParser;
import com.kuliashou.information.reader.TextReader;

public class Main {

    public static void main(String[] args) throws TextReaderException {

        String text = TextReader.readText("data/england.txt");
        Component composite = new Composite(PartType.TEXT);
        TextParser textParser = new TextParser();

        textParser.parse(composite, text);
        composite = textParser.getTextComposite();

        Component sortParagraphsByLengthOfSentences = TextAction.sortParagraphsByLengthOfSentences(composite);
        System.out.println(sortParagraphsByLengthOfSentences);

        Component sortSentencesByLengthOfLexemes = TextAction.sortSentencesByLengthOfLexemes(composite);
        System.out.println(sortSentencesByLengthOfLexemes);

    }

}
