package Kata;

import java.util.Arrays;

/**
 * There is an array with some numbers. All numbers are equal except for one. Try to find it!
 *
 * Kata.findUnique(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
 * Kata.findUnique(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
 *
 * It’s guaranteed that array contains at least 3 numbers.
 *
 * The tests contain some very huge arrays, so think about performance.
 *
 */
public class FindUniqueNumber {
    public static double findUnique(double[] arr) {
        Arrays.sort(arr);
        //erster und zweiter gleich, dann nur erster oder letzter die richtige zahl
        return arr[0] == arr[1] ? arr[arr.length-1]:arr[0];
    }
}
