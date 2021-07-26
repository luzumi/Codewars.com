package Kata;

//To give credit where credit is due: This problem was taken from the ACMICPC-Northwest Regional Programming Contest.
// Thank you problem writers.
//
//You are helping an archaeologist decipher some runes. He knows that this ancient society used a Base 10 system,
// and that they never start a number with a leading zero. He's figured out most of the digits as well as a few
// operators, but he needs your help to figure out the rest.
//
//The professor will give you a simple math expression, of the form
//
//[number][op][number]=[number]
//
//He has converted all of the runes he knows into digits. The only operators he knows are addition (+),subtraction(-),
// and multiplication (*), so those are the only ones that will appear. Each number will be in the range from
// -1000000 to 1000000, and will consist of only the digits 0-9, possibly a leading -, and maybe a few ?s.
// If there are ?s in an expression, they represent a digit rune that the professor doesn't know (never an operator,
// and never a leading -). All of the ?s in an expression will represent the same digit (0-9), and it won't be one of
// the other given digits in the expression. No number will begin with a 0 unless the number itself is 0,
// therefore 00 would not be a valid number.
//
//Given an expression, figure out the value of the rune represented by the question mark. If more than one digit works,
// give the lowest one. If no digit works, well, that's bad news for the professor - it means that he's got some of
// his runes wrong. output -1 in that case.
//
//Complete the method to solve the expression to find the value of the unknown rune. The method takes a string as a
// paramater repressenting the expression and will return an int value representing the unknown rune or -1
// if no such rune exists.

public class Runes {
    public static int solveExpression( final String expression ) {
        int missingDigit = -1;
        if(!expression.contains("?")) return missingDigit;
        System.out.println(expression);
        //looking for index of operator
        int indexOfOperator = expression.contains("*") ? expression.indexOf("*"):
                expression.contains("+") ? expression.indexOf("+"):
                        expression.substring(0, expression.length() - 1).contains("-") ?
                                    expression.substring(0,expression.length()-1).indexOf("-"): 0;

        String first;
        char operator;
        String second;
        String result;
        if(indexOfOperator == 0) {
            indexOfOperator = expression.substring(1, expression.length() - 1).indexOf("-");
            first = expression.substring(0,indexOfOperator+1);
            System.out.println(first + " first");
            operator = expression.charAt(indexOfOperator+1);
            second = expression.substring((indexOfOperator + 2), expression.indexOf("="));
            result = expression.substring(expression.indexOf("=") + 1);
        }
        else {
            first = expression.substring(0, indexOfOperator);
            System.out.println(first + " first");
            operator = expression.charAt(indexOfOperator);
            second = expression.substring((indexOfOperator + 1), expression.indexOf("="));
            result = expression.substring(expression.indexOf("=") + 1);
        }

        //replace "?"
        int checkResult;
        for (int index = 0; index <= 9; index++) {

            String firstTry = first.replace('?', (char)(index + 48));
            String secondTry = second.replace('?', (char)(index + 48));
            String resultTry = result.replace('?', (char) (index + 48));

            if(index == 0 && (firstTry.length() > 1 && Integer.parseInt(firstTry) >= 0 && first.charAt(0) == '?')) continue;
            if(index == 0 && (firstTry.length() > 1 && Integer.parseInt(firstTry) < 0 && first.charAt(1) == '?')) continue;
            if(index == 0 && (secondTry.length() > 1 && Integer.parseInt(secondTry) >= 0 && second.charAt(0) == '?')) continue;
            if(index == 0 && (secondTry.length() > 1 && Integer.parseInt(secondTry) < 0 && second.charAt(1) == '?')) continue;
            if(index == 0 && (resultTry.length() > 1 && Integer.parseInt(resultTry) >= 0 && result.charAt(0) == '?')) continue;
            if(index == 0 && (resultTry.length() > 1 && Integer.parseInt(resultTry) < 0 && result.charAt(1) == '?')) continue;

            if(Integer.parseInt(resultTry) > 1000000 || Integer.parseInt(resultTry) < -1000000) return -1;
            //check for invalid numbers
            if(firstTry.equals("00")) continue;
            if(secondTry.equals("00")) continue;
            if(resultTry.equals("00")) continue;
            if(expression.contains(Integer.toString(index))) continue;

            switch (operator) {
                case '+' -> {
                    checkResult = Integer.parseInt(firstTry) + Integer.parseInt(secondTry);
                    if (checkResult == Integer.parseInt(resultTry)) {
                        if (firstTry.equals("00") || secondTry.equals("00") || resultTry.equals("00")) break;
                        return index;
                    }
                }
                case '-' -> {
                    checkResult = Integer.parseInt(firstTry) - Integer.parseInt(secondTry);
                    if (checkResult == Integer.parseInt(resultTry)) {
                        if (firstTry.equals("00") || secondTry.equals("00") || resultTry.equals("00")) break;
                        return index;
                    }
                }
                case '*' -> {
                    checkResult = Integer.parseInt(firstTry) * Integer.parseInt(secondTry);
                    if (checkResult == Integer.parseInt(resultTry)) {
                        if (firstTry.equals("00") || secondTry.equals("00") || resultTry.equals("00")) break;
                        return index;
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + operator);
            }

        }
        return missingDigit;
    }
}
