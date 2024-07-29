package net.media.training.designpattern.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Xml {
    private String name;
    private List<Pair<String, String>> attributes;
    private String value;

    public Xml(String name, List<Pair<String, String>> attributes, String value) {
        this.name = name;
        this.attributes = attributes;
        this.value = value;
    }

    @Override
    public String toString(){
        StringBuilder tag = new StringBuilder("<"+this.name);
        for(Pair<String, String> attribute: attributes) {
            String key = attribute.getFirst();
            String value = attribute.getSecond();
            tag.append(" ");
            tag.append(key);
            tag.append("=\"");
            tag.append(value);
            tag.append("\"");
        }
        tag.append(">");
        tag.append(value);
        tag.append("</");
        tag.append(name);
        tag.append(">");
        return tag.toString();
    }
}
