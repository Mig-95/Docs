package ca.csf.pobj.tp2.MainConverter;

public class ToRomanNumerals {

    public static String IntToRomanNumber(int input) {
        if (input < 1 || input > 4999)
            throw new IllegalArgumentException("Valeur invalide"); //BEN_CORRECTION : Message d'erreur imprécis.

        //BEN_CORRECTION : Duplication de code.
        String romanNumber = "";
        while (input >= 1000) {
            romanNumber += "M";
            input -= 1000;
        }
        while (input >= 900) {
            romanNumber += "CM";
            input -= 900;
        }
        while (input >= 500) {
            romanNumber += "D";
            input -= 500;
        }
        while (input >= 400) {
            romanNumber += "CD";
            input -= 400;
        }
        while (input >= 100) {
            romanNumber += "C";
            input -= 100;
        }
        while (input >= 90) {
            romanNumber += "XC";
            input -= 90;
        }
        while (input >= 50) {
            romanNumber += "L";
            input -= 50;
        }
        while (input >= 40) {
            romanNumber += "XL";
            input -= 40;
        }
        while (input >= 10) {
            romanNumber += "X";
            input -= 10;
        }
        while (input >= 9) {
            romanNumber += "IX";
            input -= 9;
        }
        while (input >= 5) {
            romanNumber += "V";
            input -= 5;
        }
        while (input >= 4) {
            romanNumber += "IV";
            input -= 4;
        }
        while (input >= 1) {
            romanNumber += "I";
            input -= 1;
        }
        return romanNumber;
    }

}

