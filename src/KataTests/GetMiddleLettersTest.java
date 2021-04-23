package KataTests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetMiddleLettersTest {

    @Test
    public void evenTests() {
        assertEquals("es", Kata.GetMiddleLetters.getMiddle("test"));
        assertEquals("dd", Kata.GetMiddleLetters.getMiddle("middle"));
    }

    @Test
    public void oddTests() {
        assertEquals("t", Kata.GetMiddleLetters.getMiddle("testing"));
        assertEquals("A", Kata.GetMiddleLetters.getMiddle("A"));
    }
}