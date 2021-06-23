package KataTests;

import org.junit.jupiter.api.Test;
import Kata.*;
import static org.junit.jupiter.api.Assertions.*;

class FindUniqueNumberTest {

    private double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, FindUniqueNumber.findUnique(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, FindUniqueNumber.findUnique(new double[]{1, 1, 1, 2, 1, 1}), precision);
        assertEquals(3.0, FindUniqueNumber.findUnique(new double[]{4.0, 4.0, 4.0, 3.0, 4.0, 4.0, 4.0, 4.0}), precision);
        assertEquals(4.0, FindUniqueNumber.findUnique(new double[]{5.0, 5.0, 5.0, 5.0, 4.0, 5.0, 5.0, 5.0}), precision);
        assertEquals(5.0, FindUniqueNumber.findUnique(new double[]{6.0, 6.0, 6.0, 6.0, 6.0, 5.0, 6.0, 6.0}), precision);
        assertEquals(6.0, FindUniqueNumber.findUnique(new double[]{7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 6.0, 7.0}), precision);
        assertEquals(7.0, FindUniqueNumber.findUnique(new double[]{8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 8.0, 7.0}), precision);
    }
}