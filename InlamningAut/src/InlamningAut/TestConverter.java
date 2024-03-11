package InlamningAut;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestConverter {

    @Test
    public void testEngBToMorseB() {

        Converter converter = new Converter();
        String expected = "B";
        String actual = converter.getEngLetter("-***");
        assertEquals(expected, actual);
    }


    @Test
    public void testEngChartoMorseChar() {
        Converter converter = new Converter();
        String expected = "?";
        String actual = converter.getEngLetter("**--**");
        assertEquals(expected, actual);
    }

    @Test
    public void testMorseAToEngA() {
        Converter converter = new Converter();
        String expected = "*-";
        String actual = converter.getMorse("A");
        assertEquals(expected, actual);
    }

    @Test
    public void testMorseCharToEngChar() {
        Converter converter = new Converter();
        String expected = "--**--";
        String actual = converter.getMorse(",");
        assertEquals(expected, actual);
    }

    @Test
    public void testNumber1ToMorse1() {
        Converter converter = new Converter();
        String expected = "1";
        String actual = converter.getEnglishNumber("*----");
        assertEquals(expected, actual);
    }

    @Test
    public void testNumber9ToMorse9() {
        Converter converter = new Converter();
        String expected = "9";
        String actual = converter.getEnglishNumber("----*");
        assertEquals(expected, actual);
    }

    @Test
    public void testMorse0ToNumber0() {
        Converter converter = new Converter();
        String expected = "-----";
        String actual = converter.getMorseNumber("0");
        assertEquals(expected, actual);
    }

    @Test
    public void testMorse2ToNumber2() {
        Converter converter = new Converter();
        String expected = "**---";
        String actual = converter.getMorseNumber("2");
        assertEquals(expected, actual);
    }

    @Test
    public void testWrongNumberToEmpty() {
        Converter converter = new Converter();
        String expected = "";
        String actual = converter.getEnglishNumber("15");
        assertEquals(expected, actual);
    }

    @Test
    public void testWrongMorseToEmpty() {
        Converter converter = new Converter();
        String expected = "";
        String actual = converter.getEngLetter("*********");
        assertEquals(expected, actual);
    }

    @Test
    public void testWrongLetterToEmpty() {
        Converter converter = new Converter();
        String expected = "";
        String actual = converter.getMorse("Å");
        assertEquals(expected, actual);
    }

    @Test
    public void testSmallLetters() {
        Converter converter = new Converter();
        String expected = "-**";
        String actual = converter.getMorse("d");
        assertEquals(expected, actual);
    }

    @Test
    public void testBlankInput() {
        Converter converter = new Converter();
        String expected = "";
        String actual = converter.getMorse("");
        assertEquals(expected, actual);
    }
}
