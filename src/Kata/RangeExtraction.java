package Kata;

//A format for expressing an ordered list of integers is to use a comma separated list of either
//
//    individual integers
//    or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'. The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers. For example "12,13,15-17"
//
//Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.
//
//Example:
//
//Solution.rangeExtraction(new int[] {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
//# returns "-6,-3-1,3-5,7-11,14,15,17-20"
//  https://www.codewars.com/kata/51ba717bb08c1cd60f00002f/train/java
public class RangeExtraction {

    public static String rangeExtraction(int[] arr) {
        StringBuilder sb = new StringBuilder();
        char sign =',';
        sb.append(arr[0]);
        for (int i = 1; i < arr.length - 1; i++) {

            if (arr[i] - arr[i - 1] == 1 && arr[i + 1] - arr[i] == 1) {
                sign = '-';

                continue;

            } else {
                sb.append(sign);
                sign = ',';
            }
            sb.append(arr[i]);
        }
        return sb.append(sign).append(arr[arr.length - 1]).toString();
    }
}
