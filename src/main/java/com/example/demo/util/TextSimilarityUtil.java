package com.example.demo.util;

import java.util.*;

public class TextSimilarityUtil {

    public static double similarity(String s1, String s2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(s1.toLowerCase().split("\\s+")));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2.toLowerCase().split("\\s+")));
        set1.retainAll(set2);
        return (double) set1.size() / Math.max(1, Math.max(s1.length(), s2.length()));
    }
}
