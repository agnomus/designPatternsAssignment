package net.media.training.designpattern.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlTagBuilder {
    private String name;
    private List<Pair<String, String>> attributes = new ArrayList<>();
    private List<XmlTagBuilder> childTags = new ArrayList<>();
    private String value = "";

    public XmlTagBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public XmlTagBuilder addAttribute(String attributeId, String value) {
        attributes.add(new Pair<>(attributeId, value));
        return this;
    }

    public XmlTagBuilder addChildTags(XmlTagBuilder xmlTag) {
        childTags.add(xmlTag);
        return this;
    }

    public XmlTagBuilder setValue(String value) {
        this.value = value;
        return this;
    }

    public String build() {
        StringBuilder finalInnerValue = new StringBuilder(value);
        for(XmlTagBuilder child: childTags) {
            finalInnerValue.append(child.build());
        }
        return new Xml(name, attributes, finalInnerValue.toString()).toString();
    }
}
