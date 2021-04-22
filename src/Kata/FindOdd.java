package Kata;

/**
 * Given an array of integers, find the one that appears an odd number of times.
 * There will always be only one integer that appears an odd number of times.
 */
public class FindOdd {
    public static int findIt(int[] a) {
        int count = 0;

        for (int k : a) {
            for (int i : a) {
                if (k == i) {
                    count++;
                }
            }
            if (count % 2 == 1) return k;
            count = 0;
        }

        return 0;
    }
}
