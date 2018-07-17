package com.kuliashou.information.composite;

import java.util.List;

public interface Component {

    void add(Component component);

    void remove(Component component);

    List<Component> getComponents();

    PartType getPartType();

    String toString();
}
