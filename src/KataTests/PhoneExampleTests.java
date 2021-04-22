package KataTests;

import Kata.CreatePhoneNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneExampleTests {
    @Test
    public void tests() {
        assertEquals("(123) 456-7890", CreatePhoneNumber.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}