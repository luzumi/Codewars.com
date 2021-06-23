package KataTests;

import Kata.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class EncryptThisTest {

    @Test
    void encryptThis() {
        assertEquals("", EncryptThis.encryptThis(""));
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", EncryptThis.encryptThis("A wise old owl lived in an oak"));
        assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp", EncryptThis.encryptThis("The more he saw the less he spoke"));
        assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare", EncryptThis.encryptThis("The less he spoke the more he heard"));
        assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri", EncryptThis.encryptThis("Why can we not all be like that wise old bird"));
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", EncryptThis.encryptThis("Thank you Piotr for all your help"));

    }
}