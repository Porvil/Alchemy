package com.dev_pd.alchemy.data;

import java.util.Objects;

public class Element {
    public String elementName;
    public String group;

    public Element(String elementName, String group) {
        this.elementName = elementName;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return elementName.equals(element.elementName);
    }

    @Override
    public String toString() {
        return "Element{" +
                "elementName='" + elementName + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementName);
    }
}
