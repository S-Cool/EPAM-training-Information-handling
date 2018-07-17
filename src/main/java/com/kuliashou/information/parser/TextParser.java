package com.kuliashou.information.parser;

import com.kuliashou.information.composite.Component;

public class TextParser implements BaseParser {

    private SymbolParser symbolParser;
    private LexemeParser lexemeParser;
    private SentenceParser sentenceParser;
    private ParagraphParser paragraphParser;
    private Component textComposite;

    public TextParser() {
        this.symbolParser = new SymbolParser();
        this.lexemeParser = new LexemeParser(symbolParser);
        this.sentenceParser = new SentenceParser(lexemeParser);
        this.paragraphParser = new ParagraphParser(sentenceParser);
    }

    public Component getTextComposite() {
        return textComposite;
    }

    @Override
    public void parse(Component textComposite, String text) {
        if (paragraphParser !=null){
            paragraphParser.parse(textComposite, text);
        }
        this.textComposite = textComposite;
    }
}
