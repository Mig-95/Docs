package ca.csf.pobj.tp2.Utils;

public final class NumberUtils {

    private NumberUtils() {
        //Private, so it's a static class
    }

    public static Integer toInteger(String string){

        return Integer.parseInt(string);
    }
}