package Kata;

/**
 * The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if
 * that character appears only once in the original string, or ")" if that character appears more than once in the
 * original string. Ignore capitalization when determining if a character is a duplicate.
 * Examples
 *
 * "din"      =>  "((("
 * "recede"   =>  "()()()"
 * "Success"  =>  ")())())"
 * "(( @"     =>  "))(("
 *
 * Notes
 *
 * Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode XXX",
 * the "XXX" is the expected result, not the input!
 */
public class DuplicateEncoder {
    public static String encode(String word){
        StringBuilder result = new StringBuilder();
        char[] wordArr = word.toLowerCase().toCharArray();

        for (int i = 0; i < word.length(); i++){
            int count = 0;
            for (int j = 0; j < word.length(); j++){
                if (wordArr[i] == wordArr[j]) count++;
            }
            result.append(count > 1 ? ")" : "(");
        }
        return result.toString();
    }
}
