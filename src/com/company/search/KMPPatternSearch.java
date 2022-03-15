package com.company.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMPPatternSearch {
    //Computes LPS
    private int[] compilePatternArray(String pattern) {
        int patternLength = pattern.length();
        //Length of the previous longest prefix - suffix
        int len = 0;
        int i = 1;
        int[] compiledPatternArray = new int[patternLength];
        //LPS[0] is always 0
        compiledPatternArray[0] = 0;

        //The loop calculates lps[i] for i = 1 to patternLength-1
        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                compiledPatternArray[i] = len;
                i++;
            //pattern[i] != pattern[len]
            } else {
                //Checks the index saved in the LPS table from the previous letter
                //Don't increment i
                if (len != 0) {
                    len = compiledPatternArray[len - 1];
                //if len == 0
                } else {
                    compiledPatternArray[i] = len;
                    i++;
                }
            }
        }
        System.out.println("Compiled Pattern Array " + Arrays.toString(compiledPatternArray));
        return compiledPatternArray;
    }

    //Performs the KMP Search
    public List<Integer> KMPSearch(String text, String pattern) {
        //Computes the LPS
        int[] compiledPatternArray = compilePatternArray(pattern);
        int textIndex = 0;
        int patternIndex = 0;

        List<Integer> foundIndexes = new ArrayList<>();

        while (textIndex < text.length()) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                patternIndex++;
                textIndex++;
            }
            if (patternIndex == pattern.length()) {
                System.out.println("Found pattern at index: " + (textIndex - patternIndex));
                foundIndexes.add(textIndex - patternIndex);
                patternIndex = compiledPatternArray[patternIndex - 1];
            }
            //Mismatch after patternIndex matched
            else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                //Skip repeating a comparison already performed
                if (patternIndex != 0)
                    patternIndex = compiledPatternArray[patternIndex - 1];
                else
                    textIndex = textIndex + 1;
            }
        }
        return foundIndexes;
    }
}
