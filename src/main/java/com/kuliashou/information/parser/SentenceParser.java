package com.kuliashou.information.parser;

import com.kuliashou.information.composite.Component;
import com.kuliashou.information.composite.Composite;
import com.kuliashou.information.composite.PartType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements BaseParser {

    private LexemeParser lexeme;
    private static final String SENTENCE_REGEXP = "(?:[^!?.]|\\.(?=\\d))+[!?.]";

    public SentenceParser(LexemeParser lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public void parse(Component paragraphComposite, String paragraph) {
        String sentence;
        Pattern pattern = Pattern.compile(SENTENCE_REGEXP);
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find()) {
            if (lexeme != null) {
                sentence = matcher.group().replaceAll("\\s+", " ").trim();
                Component sentenceComposite = new Composite(PartType.SENTENCE);
                lexeme.parse(sentenceComposite, sentence);
                paragraphComposite.add(sentenceComposite);
            }
        }
    }
}
