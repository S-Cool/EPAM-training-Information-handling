package com.kuliashou.information.parser;

import com.kuliashou.information.composite.Component;

public interface BaseParser {
    void parse(Component composite, String text);
}
