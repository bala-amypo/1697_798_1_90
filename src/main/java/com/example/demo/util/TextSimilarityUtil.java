// package com.example.demo.util;

// import java.util.*;

// public class TextSimilarityUtil {

//     public static double similarity(String s1, String s2) {
//         Set<String> set1 = new HashSet<>(Arrays.asList(s1.toLowerCase().split("\\s+")));
//         Set<String> set2 = new HashSet<>(Arrays.asList(s2.toLowerCase().split("\\s+")));
//         set1.retainAll(set2);
//         return (double) set1.size() / Math.max(1, Math.max(s1.length(), s2.length()));
//     }
// }

package com.example.demo.util;

public class TextSimilarityUtil {

    public static double similarity(String s1, String s2) {
        if (s1 == null || s2 == null) return 0.0;

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        String[] words1 = s1.split("\\s+");
        String[] words2 = s2.split("\\s+");

        int matches = 0;
        for (String w1 : words1) {
            for (String w2 : words2) {
                if (w1.equals(w2)) {
                    matches++;
                }
            }
        }
        return (double) matches / Math.max(words1.length, words2.length);
    }
}
