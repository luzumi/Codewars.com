package Kata;

public class Solution {
    public static boolean validParentheses(String parens)
    {
        int countOpen = 0, countClose = 0;
        for (char c : parens.toCharArray()) {
            if (c == '(') countOpen++;
            if (c == '(' && countClose >= countOpen) return false;
            if (c == ')') countClose++;
        }
        return countClose == countOpen;
    }
}
