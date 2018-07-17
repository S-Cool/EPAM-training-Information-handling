package com.kuliashou.information.parser;

import com.kuliashou.information.composite.Component;
import com.kuliashou.information.composite.Composite;
import com.kuliashou.information.composite.PartType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements BaseParser {
    private SentenceParser sentence;
    private static final String PARAGRAPH_REGEXP = "(?sm)^[^\\s]+.*?\\.\\s*$";

    public ParagraphParser(SentenceParser sentence) {
        this.sentence = sentence;
    }

    @Override
    public void parse(Component textComposite, String text) {
        Pattern paragraphPattern = Pattern.compile(PARAGRAPH_REGEXP);
        Matcher matcher = paragraphPattern.matcher(text);
        String[] paragraphs = text.split(PARAGRAPH_REGEXP);

        for (String paragraph : paragraphs) {
            paragraph = paragraph.trim();
            if (matcher.find()) {
                paragraph = paragraph + " " + matcher.group();
            }

            if (sentence != null) {
                Component paragraphComposite = new Composite(PartType.PARAGRAPH);
                sentence.parse(paragraphComposite, paragraph);
                textComposite.add(paragraphComposite);
            }
        }
    }
}
