package Kata;

/*
Create a function taking a positive integer as its parameter and returning a string containing the Roman Numeral
representation of that integer.

Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any
digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is
written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.

Example:

conversion.solution(1000); //should return "M"

Help:

Symbol    Value
I          1
V          5
X          10
L          50
C          100
D          500
M          1,000

Remember that there can't be more than 3 identical symbols in a row.
 */
public class Conversion {

    public String solution(int n) {
        int startNumber = n;
        String result = "";

        while (n > 0) {
            if (n >= 1000) {
                result += "M";
                n -= 1000;
                result = optimize(result);
                continue;
            }
            if (n >= 500) {
                result += "D";
                n -= 500;
                result = optimize(result);
                continue;
            }
            if (n >= 100) {
                result += "C";
                n -= 100;
                result = optimize(result);
                continue;
            }
            if (n >= 50) {
                result += "L";
                n -= 50;
                result = optimize(result);
                continue;
            }
            if (n >= 10) {
                result += "X";
                n -= 10;
                result = optimize(result);
                continue;
            }
            if (n >= 5) {
                result += "V";
                n -= 5;
                result = optimize(result);
                continue;
            }
            result += "I";
            n -= 1;
            result = optimize(result);

        }

        return result;
    }

    public String optimize(String mRom) {
        mRom = mRom.replace("VIIII", "IX");
        mRom = mRom.replace("IIII", "IV");
        mRom = mRom.replace("LXXXX", "XC");
        mRom = mRom.replace("XXXX", "XL");
        mRom = mRom.replace("DCCCC", "CM");
        mRom = mRom.replace("CCCC", "CD");
        return mRom;
    }
}
