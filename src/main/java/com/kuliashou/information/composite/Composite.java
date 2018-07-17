package com.kuliashou.information.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private List<Component> parts;
    private PartType partType;

    public Composite(PartType partType) {
        this.parts = new ArrayList<>();
        this.partType = partType;
    }

    public void add(Component component) {
        parts.add(component);
    }

    public void remove(Component component) {
        parts.remove(component);
    }

    @Override
    public List<Component> getComponents() {
        return parts;
    }

    @Override
    public PartType getPartType() {
        return partType;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : parts) {
            if (component.getPartType() == PartType.PARAGRAPH) {
                stringBuilder.append("   ");
            }
            if (component.getPartType() == PartType.LEXEME) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
    }
}