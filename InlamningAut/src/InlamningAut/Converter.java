package InlamningAut;

import java.util.HashMap;

public class Converter {

    private HashMap<String, String> morseToLetters;
    private HashMap<String, String> lettersToMorse;

    private HashMap<String, String> numbersToMorse;
    private HashMap<String, String> morseToNumbers;



    public Converter() {

        lettersToMorse = new HashMap<>();
        lettersToMorse.put("A", "*-");
        lettersToMorse.put("B", "-***");
        lettersToMorse.put("C", "-*-*");
        lettersToMorse.put("D", "-**");
        lettersToMorse.put("E", "*");
        lettersToMorse.put("F", "**-*");
        lettersToMorse.put("G", "--*");
        lettersToMorse.put("H", "****");
        lettersToMorse.put("I", "**");
        lettersToMorse.put("J", "*---");
        lettersToMorse.put("K", "-*-");
        lettersToMorse.put("L", "*-**");
        lettersToMorse.put("M", "--");
        lettersToMorse.put("N", "-*");
        lettersToMorse.put("O", "---");
        lettersToMorse.put("P", "*--*");
        lettersToMorse.put("Q", "--*-");
        lettersToMorse.put("R", "*-*");
        lettersToMorse.put("S", "***");
        lettersToMorse.put("T", "-");
        lettersToMorse.put("U", "**-");
        lettersToMorse.put("V", "***-");
        lettersToMorse.put("W", "*--");
        lettersToMorse.put("X", "-**-");
        lettersToMorse.put("Y", "-*--");
        lettersToMorse.put("Z", "--**");
        lettersToMorse.put(".", "*-*-*-");
        lettersToMorse.put(",", "--**--");
        lettersToMorse.put("?", "**--**");


        morseToLetters = new HashMap<>();
        morseToLetters.put("*-", "A");
        morseToLetters.put("-***", "B");
        morseToLetters.put("-*-*", "C");
        morseToLetters.put("-**", "D");
        morseToLetters.put("*", "E");
        morseToLetters.put("**-*", "F");
        morseToLetters.put("--*", "G");
        morseToLetters.put("****", "H");
        morseToLetters.put("**", "I");
        morseToLetters.put("*---", "J");
        morseToLetters.put("-*-", "K");
        morseToLetters.put("*-**", "L");
        morseToLetters.put("--", "M");
        morseToLetters.put("-*", "N");
        morseToLetters.put("---", "O");
        morseToLetters.put("*--*", "P");
        morseToLetters.put("--*-", "Q");
        morseToLetters.put("*-*", "R");
        morseToLetters.put("***", "S");
        morseToLetters.put("-", "T");
        morseToLetters.put("**-", "U");
        morseToLetters.put("***-", "V");
        morseToLetters.put("*--", "W");
        morseToLetters.put("-**-", "X");
        morseToLetters.put("-*--", "Y");
        morseToLetters.put("--**", "Z");
        morseToLetters.put("*-*-*-", ".");
        morseToLetters.put("--**--", ",");
        morseToLetters.put("**--**", "?");


        numbersToMorse = new HashMap<>();
        numbersToMorse.put("1", "*----");
        numbersToMorse.put("2", "**---");
        numbersToMorse.put("3", "***--");
        numbersToMorse.put("4", "****-");
        numbersToMorse.put("5", "*****");
        numbersToMorse.put("6", "-****");
        numbersToMorse.put("7", "--***");
        numbersToMorse.put("8", "---**");
        numbersToMorse.put("9", "----*");
        numbersToMorse.put("0", "-----");

        morseToNumbers = new HashMap<>();
        morseToNumbers.put("*----", "1");
        morseToNumbers.put("**---", "2");
        morseToNumbers.put("***--", "3");
        morseToNumbers.put("****-", "4");
        morseToNumbers.put("*****", "5");
        morseToNumbers.put("-****", "6");
        morseToNumbers.put("--***", "7");
        morseToNumbers.put("---**", "8");
        morseToNumbers.put("----*", "9");
        morseToNumbers.put("-----", "0");
    }


    public String getMorse(String letter) {
        if (lettersToMorse.get(letter.toUpperCase()) != null) {
            return lettersToMorse.get(letter.toUpperCase());
        } else {
            return "";
        }
    }

    public String getEngLetter(String letter) {
        if (morseToLetters.get(letter.toUpperCase()) != null) {
            return morseToLetters.get(letter.toUpperCase());
        } else {
            return "";
        }
    }


    public String getMorseNumber(String morseN) {
        if (numbersToMorse.get(morseN) != null) {
            return numbersToMorse.get(morseN);
        } else {
            return "";
        }

    }

    public String getEnglishNumber(String number) {
        if (morseToNumbers.get(number) != null) {
            return morseToNumbers.get(number);
        } else {
            return "";
        }
    }
}




