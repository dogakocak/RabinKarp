package com.company;

import java.util.HashMap;
import java.util.Map;

public class RobinKarp {
    private final String pattern;
    private final String text;
    Map<Character, Integer> hashes;
    protected int test;

    public RobinKarp(String pattern, String text) {
        this.pattern = pattern;
        this.text = text;
        CreateMap();
    }

    public void CreateMap() {
        int val = 1;
        hashes = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (!hashes.containsKey(c)) hashes.put(c, val++);
        }
    }

    public void Search() {
        int patternSize = pattern.length() - 1;
        int totalValue = 0;
        int firstValue = CharValue(hashes.get(text.charAt(0)),patternSize);
        int flag = 0;
        for (int i =0; i<text.length(); i++) {
            char c = text.charAt(i);
            if (patternSize == -1) {
                patternSize = pattern.length() - 1;
            }
            if (flag < pattern.length()){
                totalValue += CharValue(hashes.get(c),patternSize--);
            }
            else{
                if (totalValue == PatternValue()){
                    System.out.println(text +" contains " + pattern);
                    return;
                }
                c = text.charAt(i-2);
                totalValue -= firstValue;
                firstValue = CharValue(hashes.get(c),patternSize);
                patternSize = 0;
                totalValue *= 10;
                totalValue += CharValue(hashes.get(text.charAt(i)),patternSize--);
            }
            flag++;
        }
        System.err.println("Pattern is not found!");
    }

    public int PatternValue() {
        int patternSize = pattern.length() - 1;
        int totalValue = 0;
        for (char c : pattern.toCharArray()) {
            if (hashes.get(c) == null){
                System.err.println("Text can not contain this pattern");
                System.exit(0);
            }
            totalValue += CharValue(hashes.get(c), patternSize--);
        }
        return totalValue;
    }

    public int CharValue(int coefficient, int power) {
        return (int) (coefficient * (Math.pow(10, power)));
    }
}
