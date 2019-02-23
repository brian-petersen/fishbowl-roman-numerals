package RomanNumerals;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterTest {

    private Converter converter = new Converter();

    @Test
    public void convertNumber() {
        assertEquals("III", converter.convertNumber(3));
        assertEquals("IV", converter.convertNumber(4));
        assertEquals("V", converter.convertNumber(5));
        assertEquals("VI", converter.convertNumber(6));

        assertEquals("XII", converter.convertNumber(12));

        assertEquals("XXXIX", converter.convertNumber(39));

        assertEquals("XLVI", converter.convertNumber(46));
        assertEquals("LIV", converter.convertNumber(54));

        assertEquals("XCIX", converter.convertNumber(99));
        assertEquals("C", converter.convertNumber(100));

        assertEquals("CCIX", converter.convertNumber(209));
        assertEquals("CCXLIX", converter.convertNumber(249));

        assertEquals("I", converter.convertNumber(1));
        assertEquals("XVIII", converter.convertNumber(18));
        assertEquals("CCXII", converter.convertNumber(212));

    }

    @Test(expected = ConverterException.class)
    public void convertNumberExceptionLower() {
        converter.convertNumber(0);
    }

    @Test(expected = ConverterException.class)
    public void convertNumberExceptionUpper() {
        converter.convertNumber(256);
    }

    @Test
    public void convertNumberBoundaries() {
        converter.convertNumber(1);
        converter.convertNumber(255);
    }
}
