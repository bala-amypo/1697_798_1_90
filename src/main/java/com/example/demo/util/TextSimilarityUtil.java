package com.example.demo.util;

public class TextSimilarityUtil {

    public static double similarity(String s1, String s2) {
        if (s1 == null || s2 == null) return 0.0;
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int common = 0;
        for (String word : s1.split(" ")) {
            if (s2.contains(word)) {
                common++;
            }
        }
        return (double) common / Math.max(s1.split(" ").length, 1);
    }
}
