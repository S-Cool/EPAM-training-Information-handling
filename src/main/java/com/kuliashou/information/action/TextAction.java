package com.kuliashou.information.action;

import com.kuliashou.information.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class TextAction {

    /**
     * Paragraph sorting by sentences count.
     *
     * @param textComposite text in composite format
     * @return sorted by length paragraphs
     */
    public static Component sortParagraphsByLengthOfSentences(Component textComposite) {
        List<Component> paragraphs = textComposite.getComponents();
        sortComponents(paragraphs);
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
        return textComposite;
    }

    /**
     * Custom Bubble sort for composite
     *
     * @param components list components for sorting
     */
    private static void sortComponents(List<Component> components) {
        int componentSize = components.size();

        for (int i = componentSize - 1; i > 0; i--) {
            for (int j = 0; i > j; j++) {
                Component partFirst = components.get(j);
                Component partSecond = components.get(j + 1);

                int FirstLength = partFirst.getComponents().size();
                int SecondLength = partSecond.getComponents().size();

                if (FirstLength > SecondLength) {
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