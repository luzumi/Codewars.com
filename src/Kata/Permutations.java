package Kata;

import java.util.ArrayList;
import java.util.List;

//In this kata you have to create all permutations of an input string and remove duplicates, if present. This means,
// you have to shuffle all letters from the input in all possible orders.
//
//  Examples:
//
//  Permutations.singlePermutations("a") `shouldBe` ["a"]
//  Permutations.singlePermutations("ab") `shouldBe` ["ab", "ba"]
//  Permutations.singlePermutations("aabb") `shouldBe` ["aabb","abab","abba","baab","baba","bbaa"]
//
//The order of the permutations doesn't matter.

public class Permutations {

    public static List<String> singlePermutations(String s) {
        ArrayList<String> res = new ArrayList<String>();
        // If input string's length is 1, return {s}
        if (s.length() == 1) {
            res.add(s);
        } else if (s.length() > 1) {
            int lastIndex = s.length() - 1;
            // Find out the last character
            String last = s.substring(lastIndex);
            // Rest of the string
            String rest = s.substring(0, lastIndex);
            // Perform permutation on the rest string and
            // merge with the last character
            res = (ArrayList<String>) merge((ArrayList<String>) singlePermutations(rest), last);
        }

        return res;
    }
    public static List<String> merge(ArrayList<String> list, String c) {
        ArrayList<String> res = new ArrayList<>();

        for (String s : list) {
            for (int i = 0; i <= s.length(); ++i) {
                String ps = new StringBuffer(s).insert(i, c).toString();

                if(!res.contains(ps)) res.add(ps);
            }
        }
        return res;
    }
}
