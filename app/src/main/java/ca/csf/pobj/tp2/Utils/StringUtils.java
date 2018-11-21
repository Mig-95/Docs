package ca.csf.pobj.tp2.Utils;

public final class StringUtils {


    private StringUtils() {
        //Private, so it's a static class

    }

    public static boolean isBlank(String string) {
        // return string.trim().isEmpty();

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isWhitespace(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
