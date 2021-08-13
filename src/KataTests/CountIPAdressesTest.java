package KataTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountIPAddressesTest {

    @Test
    public void ipsBetween() {
        Assertions.assertEquals( 50, Kata.CountIPAdresses.ipsBetween( "10.0.0.0", "10.0.0.50" ) );
        Assertions.assertEquals( 246, Kata.CountIPAdresses.ipsBetween( "20.0.0.10", "20.0.1.0" ) );
    }

}