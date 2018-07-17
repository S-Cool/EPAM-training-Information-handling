package com.kuliashou.information.main;

import com.kuliashou.information.composite.Component;
import com.kuliashou.information.composite.Composite;
import com.kuliashou.information.composite.PartType;
import com.kuliashou.information.exception.TextReaderException;
import com.kuliashou.information.parser.TextParser;
import com.kuliashou.information.reader.TextReader;

public class Main {

    public static void main(String[] args) throws TextReaderException {

        String text = TextReader.readText("data/text.txt");
        Component composite = new Composite(PartType.TEXT);
        TextParser textParser = new TextParser();

        textParser.parse(composite, text);
        composite = textParser.getTextComposite();
        String actual = composite.toString();

        System.out.println(actual);
    }

    //Ко всем проверяемым исключениям logger не пишем.
    // Исключения обычно dao, pool, service по одному
    // dao исключения наследовать от sql исключений
}
