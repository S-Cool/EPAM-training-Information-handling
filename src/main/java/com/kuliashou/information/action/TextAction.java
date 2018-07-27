package com.kuliashou.information.action;

import com.kuliashou.information.composite.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextAction {

    private static Logger logger = LogManager.getLogger();

    /**
     * Paragraph sorting by sentences count.
     *
     * @param textComposite text in composite format
     * @return sorted by length paragraphs
     */
    public static Component sortParagraphsByLengthOfSentences(Component textComposite) {
        List<Component> paragraphs = textComposite.getComponents();
        sortComponents(paragraphs);
        logger.info("Text has sorted by length of sentences.");
        return textComposite;
    }

    /**
     * Sentences sorting by lexemes length.
     *
     * @param textComposite text in composite format
     * @return sorted by length lexemes
     */
    public static Component sortSentencesByLengthOfLexemes(Component textComposite) {
        for (Component paragraph : textComposite.getComponents()) {
            for (Component sentence : paragraph.getComponents()) {
                List<Component> lexemes = sentence.getComponents();
                sortComponents(lexemes);
            }
        }
        logger.info("Text has sorted by length of lexemes.");
        return textComposite;
    }

    /**
     * Custom Bubble sort for composite elements.
     *
     * @param components list components for sorting
     */
    private static void sortComponents(List<Component> components) {
        int componentSize = components.size();

        for (int i = componentSize - 1; i > 0; i--) {
            for (int j = 0; i > j; j++) {
                Component partFirst = components.get(j);
                Component partSecond = components.get(j + 1);

                int firstLength = partFirst.getComponents().size();
                int secondLength = partSecond.getComponents().size();

                if (firstLength > secondLength) {
                    List<Component> first = new ArrayList<>(partFirst.getComponents());
                    List<Component> second = new ArrayList<>(partSecond.getComponents());

                    for (Component component : first) {
                        partFirst.remove(component);
                        partSecond.add(component);
                    }

                    for (Component component : second) {
                        partFirst.add(component);
                        partSecond.remove(component);
                    }
                }
            }
        }
    }


}