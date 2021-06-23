package KataTests;

import Kata.HighAndLow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighAndLowTest {

    @Test
    void highAndLow() {
        assertEquals("42 -9", HighAndLow.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }
}