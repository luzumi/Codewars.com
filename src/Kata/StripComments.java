package Kata;

import java.util.Arrays;

public class StripComments {

    //Complete the solution so that it strips all text that follows any of a set of comment markers passed in.
    // Any whitespace at the end of the line should also be stripped out.
    //
    //Example:
    //
    //Given an input string of:
    //
    //apples, pears # and bananas
    //grapes
    //bananas !apples
    //
    //The output expected would be:
    //
    //apples, pears
    //grapes
    //bananas
    //
    //The code would be called like so:
    //
    //var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
    //// result should == "apples, pears\ngrapes\nbananas"
    public static String stripComments(String text, String[] commentSymbols) {
        String[] lines = text.split("\n");
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(lines));
        for (String line : lines) {
            StringBuilder lineResult = new StringBuilder();
            boolean run = true;
            for (int i = 0; i < line.length(); i++) {
                for (String commentSymbol : commentSymbols) {
                    if (line.charAt(i) == commentSymbol.charAt(0)) {
                        run = false;
                        break;
                    }
                }
                if (run) {
                    lineResult.append(line.charAt(i));
                }
            }

            sb.append(lineResult.toString().stripTrailing()).append("\n");
        }
        return sb.substring(0,sb.length()-1);
    }
}
