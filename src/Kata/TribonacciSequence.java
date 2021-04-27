package Kata;

/**
 * Well met with Fibonacci bigger brother, AKA Tribonacci.
 * <p>
 * As the name may already reveal, it works basically like a Fibonacci, but summing the last 3 (instead of 2) numbers
 * of the sequence to generate the next. And, worse part of it, regrettably I won't get to hear non-native Italian
 * speakers trying to pronounce it :(
 * <p>
 * So, if we are to start our Tribonacci sequence with [1, 1, 1] as a starting input (AKA signature), we have this
 * sequence:
 * <p>
 * [1, 1 ,1, 3, 5, 9, 17, 31, ...]
 * <p>
 * But what if we started with [0, 0, 1] as a signature? As starting with [0, 1] instead of [1, 1] basically shifts
 * the common Fibonacci sequence by once place, you may be tempted to think that we would get the same sequence shifted
 * by 2 places, but that is not the case and we would get:
 * <p>
 * [0, 0, 1, 1, 2, 4, 7, 13, 24, ...]
 * <p>
 * Well, you may have guessed it by now, but to be clear: you need to create a fibonacci function that given a signature
 * array/list, returns the first n elements - signature included of the so seeded sequence.
 * <p>
 * Signature will always contain 3 numbers; n will always be a non-negative number; if n == 0, then return an
 * empty array (except in C return NULL) and be ready for anything else which is not clearly specified ;)
 * <p>
 * If you enjoyed this kata more advanced and generalized version of it can be found in the Xbonacci kata
 * <p>
 * [Personal thanks to Professor Jim Fowler on Coursera for his awesome classes that I really recommend to any math
 * enthusiast and for showing me this mathematical curiosity too with his usual contagious passion :)]
 */
public class TribonacciSequence {
    public double[] tribonacci(double[] s, int n) {
        double[] result = new double[n];
        switch (n) {
            case 0:
                return new double[0];
            case 1:
                return new double[]{s[0]};
            case 2:
                return new double[]{s[0], s[1]};
        }
        switch (s.length) {
            case 0:
                return null;
            case 1:
                s = new double[]{0, 0, s[0]};
                break;
            case 2:
                s = new double[]{0, s[0], s[1]};
                break;
        }
        result[0] = s[0];
        result[1] = s[1];
        result[2] = s[2];
        for (int i = 1; i < n - 2; i++) {
            for (int j = 3; j < n; j++) {
                result[j] = result[j - 3] + result[j - 2] + result[j - 1];
            }
        }
        return result;
    }
}
