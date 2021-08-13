package Kata;

//  Implement a function that receives two IPv4 addresses, and returns the number of addresses between them
//   (including the first one, excluding the last one).
//
//  All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the
//  first one.
//    Examples
//
//    ips_between("10.0.0.0", "10.0.0.50")  ==   50
//    ips_between("10.0.0.0", "10.0.1.0")   ==  256
//    ips_between("20.0.0.10", "20.0.1.0")  ==  246

public class CountIPAdresses {
    public static long ipsBetween(String start, String end) {

        String[] startIPs = start.split("[.]");
        String[] endIPs = end.split("[.]");
        StringBuilder convertHighestToBinary = new StringBuilder(32);
        StringBuilder convertLowestToBinary = new StringBuilder(32);

        for (int i = 3; i >= 0; i--) {
            //insert 4 parts of binarys
            convertLowestToBinary.insert(0, Integer.parseInt (Integer.toBinaryString (Integer.parseInt (startIPs[i]))));
            convertHighestToBinary.insert(0, Integer.parseInt (Integer.toBinaryString (Integer.parseInt(endIPs[i]))));
            //fill blocks up to 8 bits
            while (convertLowestToBinary.length() % 8 != 0) {
                convertLowestToBinary.insert(0, '0');
            }
            while (convertHighestToBinary.length() % 8 != 0) {
                convertHighestToBinary.insert(0, '0');
            }
        }

        long highestIPCount = Long.parseLong(String.valueOf(convertHighestToBinary), 2);
        long lowestIPCount = Long.parseLong(String.valueOf(convertLowestToBinary), 2);

        return highestIPCount - lowestIPCount;
    }
}
