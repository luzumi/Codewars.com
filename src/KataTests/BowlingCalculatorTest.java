package KataTests;

import Kata.BowlingCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingCalculatorTest {

    @Test
    void bowling_score() {
        ////assertEquals("expected", "actual");
        //System.out.println("Maybe this bowler should put bumpers on...\n ");
        //assertEquals(20, BowlingCalculator.bowling_score("11 11 11 11 11 11 11 11 11 11"));
//
        System.out.println("Woah! Perfect game!");
        assertEquals(300, BowlingCalculator.bowling_score("X X X X X X X X X XXX"));
        assertEquals(115, BowlingCalculator.bowling_score("00 5/ 4/ 53 33 22 4/ 5/ 45 XXX"));
        assertEquals(150, BowlingCalculator.bowling_score("9/ 01 5/ 7/ 72 X 62 X 1/ XXX"));
        assertEquals(150, BowlingCalculator.bowling_score("5/ 4/ 3/ 2/ 1/ 0/ X 9/ 4/ 8/8"));
        assertEquals(122, BowlingCalculator.bowling_score("8/ X 34 8/ 34 6/ 1/ 33 80 1/X"));
        assertEquals(171, BowlingCalculator.bowling_score("X X 9/ 80 X X 90 8/ 7/ 44"));
        assertEquals(144, BowlingCalculator.bowling_score("X 81 7/ 7/ 8/ 22 X 9/ 4/ 1/X"));
        assertEquals(40, BowlingCalculator.bowling_score("00 00 00 00 00 00 00 00 X 0/X"));
        assertEquals(107, BowlingCalculator.bowling_score("71 54 06 00 6/ 13 5/ 40 X XX1"));
    }
}