package com.brzyang.java8;

import com.alphatok.graph.tree.GraphVizTreeFileBuilder;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();
//        System.out.println(characters.lengthOfLongestSubstring(""));
        System.out.println(characters.lengthOfLongestSubstring(""));
        System.out.println(characters.lengthOfLongestSubstring("a") );
        System.out.println(characters.lengthOfLongestSubstring("aa") );
        System.out.println(characters.lengthOfLongestSubstring("ababaa"));
        System.out.println(characters.lengthOfLongestSubstring("abcaaabcd"));
        System.out.println(characters.lengthOfLongestSubstring("dvdf")); // important

        GraphVizTreeFileBuilder builder = GraphVizTreeFileBuilder.create(null);
        System.out.println("builder.build() = " + builder.build());


    }

    public int lengthOfLongestSubstring(String s) {
        int max_length = 0;

        int[] cache = new int[256];
        int index = s.length();
        int count = 0;
        for (int i = 0; i < index; i++) {
            char ch = s.charAt(i);
            if (isDuplicated(cache, ch)) {
                String unduplicated = s.substring(i - count, i);
                count = count - trimDuplicated(unduplicated, cache, ch);
            }

            setCache(cache, ch);
            count++;
            if (count > max_length) {
                max_length = count;
            }
        }

        return max_length;
    }

    private int trimDuplicated(String unduplicated, int[] cache, char ch) {
        int trimCount = 0;
        for (int i = 0; i < unduplicated.length(); i++) {
            char c = unduplicated.charAt(i);
            ++trimCount;
            cache[c] = 0;
            if (c == ch) {
                break;
            }else{
            }
        }
        return trimCount;
    }

    private void setCache(int[] cache, char ch) {
        cache[ch] = 1;
    }

    private boolean isDuplicated(int[] cache, char ch) {
        if (cache[ch] > 0) {
            return true;
        }else {
            return false;
        }
    }
}
