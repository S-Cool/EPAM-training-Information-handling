package com.kuliashou.information.parser;

import com.kuliashou.information.composite.Component;
import com.kuliashou.information.composite.Composite;
import com.kuliashou.information.composite.PartType;

public class LexemeParser implements BaseParser {

    private SymbolParser symbol;
    private static final String LEXEME_REGEXP = "\\s";

    public LexemeParser(SymbolParser symbol) {
        this.symbol = symbol;
    }

    @Override
    public void parse(Component sentenceComposite, String sentence) {
        Component lexemeComposite;
        String[] lexemes = sentence.split(LEXEME_REGEXP);
        for (String lexeme : lexemes) {
            lexemeComposite = new Composite(PartType.LEXEME);
            symbol.parse(lexemeComposite, lexeme);
            sentenceComposite.add(lexemeComposite);
        }
    }
}
