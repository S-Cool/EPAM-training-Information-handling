package com.kuliashou.information.composite;

import java.util.List;

public class Leaf implements Component {

    private char leaf;
    private PartType partType;

    public Leaf(char leaf, PartType partType) {
        this.leaf = leaf;
        this.partType = partType;
    }

    @Override
    public void add(Component component) {
        //Stub
    }

    @Override
    public void remove(Component component) {
        //Stub
    }

    @Override
    public List<Component> getComponents() {
        return null;
    }

    @Override
    public PartType getPartType() {
        return partType;
    }

    @Override
    public String toString() {
        return String.valueOf(leaf);
    }
}
