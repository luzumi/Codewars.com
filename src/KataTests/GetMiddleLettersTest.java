package KataTests;

import org.junit.jupiter.api.Test;
import Kata.*;
import static org.junit.jupiter.api.Assertions.*;

class GetMiddleLettersTest {

    @Test
    public void evenTests() {
        assertEquals("es", GetMiddleLetters.getMiddle("test"));
        assertEquals("dd", GetMiddleLetters.getMiddle("middle"));
    }

    @Test
    public void oddTests() {
        assertEquals("t", GetMiddleLetters.getMiddle("testing"));
        assertEquals("A", GetMiddleLetters.getMiddle("A"));
    }
}