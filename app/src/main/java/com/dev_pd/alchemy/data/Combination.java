package com.dev_pd.alchemy.data;

import java.util.ArrayList;

public class Combination {
    public ArrayList<String> combination;
    public String result;

    public Combination(String[] data) {
        this.combination = new ArrayList<>();
        int length = data.length;
        this.result = data[length-1];
        for(int i=0;i<length-1;i++){
            this.combination.add(data[i]);
        }

    }

    @Override
    public String toString() {
        return "Combination{" +
                "combination=" + combination +
                ", result='" + result + '\'' +
                '}';
    }
}
