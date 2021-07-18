package com.dev_pd.alchemy.data;

import java.util.ArrayList;
import java.util.Objects;

public class Group {
    public String groupName;
    public ArrayList<String> elements;

    public Group(String groupName) {
        this.groupName = groupName;
        this.elements = new ArrayList<>();
    }

    public void addElement(String element){
        elements.add(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupName.equals(group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", elements=" + elements +
                '}';
    }
}
