package com.dev_pd.alchemy.data;

import java.util.ArrayList;

public class Data {
    public ArrayList<Element> elements;
    public ArrayList<Group> groups;
    public ArrayList<Combination> combinations;

    public Data() {
        elements = new ArrayList<>();
        groups = new ArrayList<>();
        combinations = new ArrayList<>();

        init();
        initCombinations();
    }

    public void init(){
        String sss =  ElementData.elements;
        String[] ss = sss.split("\n");
        for(String s : ss) {
            String[] split = s.split(",");
            String element = split[0];
            String group = split[1];
            Element element1 = new Element(element, group);
            elements.add(element1);
            Group temp = new Group(group);
            if (!groups.contains(temp)){
                groups.add(temp);
            }
            groups.get(groups.indexOf(temp)).addElement(element);
        }
    }

    public void initCombinations(){
        String sss =  ElementData.combinations;
        String[] ss = sss.split("\n");
        for(String s : ss) {
            String[] split = s.split(",");
            int length = split.length;
            if(length > 2){
                Combination combination = new Combination(split);
                combinations.add(combination);
            }
        }
    }

    public Element getElement(String element){
        for(Element element1 : elements){
            if(element1.elementName.equals(element))
                return element1;
        }

        return null;
    }

}
