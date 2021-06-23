package KataTests;
import Kata.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD by writing your own tests

public class ParenthesesTest {
    @Test
    public void sampleTest() {
        // assertEquals("expected", "actual");
        assertEquals(true,Solution.validParentheses( "()" ));
        assertEquals(false,Solution.validParentheses( "())" ));
        assertEquals(true,Solution.validParentheses( "32423(sgsdg)" ));
        assertEquals(false,Solution.validParentheses( "(dsgdsg))2432" ));
        assertEquals(true,Solution.validParentheses( "adasdasfa" ));
        assertEquals(false,Solution.validParentheses( ",Rh)(o)k^=(){(+((m))Zd" ));
    }
}
