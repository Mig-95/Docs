package ca.csf.pobj.tp2.MainConverter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ToRomanNumeralsTest {
    @Test
    public void toRomanNumeralsTest() {
        assertEquals("V", ToRomanNumerals.IntToRomanNumber(5));
        assertEquals("MMMM", ToRomanNumerals.IntToRomanNumber(4000));
        assertEquals("IX", ToRomanNumerals.IntToRomanNumber(9));
        assertEquals("CM", ToRomanNumerals.IntToRomanNumber(900));
        assertEquals("MCMLXXIII", ToRomanNumerals.IntToRomanNumber(1973));
        assertEquals("CDXLIV", ToRomanNumerals.IntToRomanNumber(444));
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowRuntimeExceptionWhenNumberIsNull() throws Exception {
        ToRomanNumerals.IntToRomanNumber(0);
    }
    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowRuntimeExceptionWhenNumberIsNotValid() throws Exception {
        ToRomanNumerals.IntToRomanNumber(5000);
    }
}