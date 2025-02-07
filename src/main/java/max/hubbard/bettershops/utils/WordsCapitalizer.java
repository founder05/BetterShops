package max.hubbard.bettershops.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WordsCapitalizer {

    public static String capitalizeEveryWord(String source) {
        return capitalizeEveryWord(source, null, null);
    }

    public static String capitalizeEveryWord(String source, Locale locale) {
        return capitalizeEveryWord(source, null, locale);
    }

    public static String capitalizeEveryWord(String source, List<Delimiter> delimiters, Locale locale) {
        char[] chars;

        if (delimiters == null || delimiters.size() == 0)
            delimiters = getDefaultDelimiters();

        // If Locale specified, i18n toLowerCase is executed, to handle specific behaviors (eg. Turkish dotted and dotless 'i')
        if (locale != null)
            chars = source.toLowerCase(locale).toCharArray();
        else
            chars = source.toLowerCase().toCharArray();

        // First charachter ALWAYS capitalized, if it is a Letter.
        if (chars.length > 0 && Character.isLetter(chars[0]) && isSurrogate(chars[0])) {
            chars[0] = Character.toUpperCase(chars[0]);
        }

        for (int i = 0; i < chars.length; i++) {
            if (isSurrogate(chars[i]) && !Character.isLetter(chars[i])) {
                // Current char is not a Letter; gonna check if it is a delimitrer.
                for (Delimiter delimiter : delimiters) {
                    if (delimiter.getDelimiter() == chars[i]) {
                        // Delimiter found, applying rules...
                        if (delimiter.capitalizeBefore() && i > 0 && Character
                            .isLetter(chars[i - 1]) && isSurrogate(chars[i
                            - 1])) {   // previous character is a Letter and I have to capitalize it
                            chars[i - 1] = Character.toUpperCase(chars[i - 1]);
                        }
                        if (delimiter.capitalizeAfter() && i < chars.length - 1 && Character
                            .isLetter(chars[i + 1]) && isSurrogate(chars[i
                            + 1])) {   // next character is a Letter and I have to capitalize it
                            chars[i + 1] = Character.toUpperCase(chars[i + 1]);
                        }
                        break;
                    }
                }
            }
        }
        return String.valueOf(chars);
    }


    private static boolean isSurrogate(char chr) {
        // Check if the current character is part of an UTF-16 Surrogate Pair.
        // Note: not validating the pair, just used to bypass (any found part of) it.
        return (!Character.isHighSurrogate(chr) && !Character.isLowSurrogate(chr));
    }

    private static List<Delimiter> getDefaultDelimiters() {
        // If no delimiter specified, "Capitalize after space" rule is set by default.
        List<Delimiter> delimiters = new ArrayList<Delimiter>();
        delimiters.add(new Delimiter(Behavior.CAPITALIZE_AFTER_MARKER, ' '));
        return delimiters;
    }

    public static class Delimiter {
        private final Behavior behavior;
        private final char delimiter;

        public Delimiter(Behavior behavior, char delimiter) {
            super();
            this.behavior = behavior;
            this.delimiter = delimiter;
        }

        public boolean capitalizeBefore() {
            return (behavior.equals(Behavior.CAPITALIZE_BEFORE_MARKER)
                    || behavior.equals(Behavior.CAPITALIZE_BEFORE_AND_AFTER_MARKER));
        }

        public boolean capitalizeAfter() {
            return (behavior.equals(Behavior.CAPITALIZE_AFTER_MARKER)
                    || behavior.equals(Behavior.CAPITALIZE_BEFORE_AND_AFTER_MARKER));
        }

        public char getDelimiter() {
            return delimiter;
        }
    }

    public enum Behavior {
        CAPITALIZE_AFTER_MARKER(0),
        CAPITALIZE_BEFORE_MARKER(1),
        CAPITALIZE_BEFORE_AND_AFTER_MARKER(2);

        private final int value;

        Behavior(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static List<String> getParts(String string, int partitionSize) {
        List<String> parts = new ArrayList<String>();
        int len = string.length();
        for (int i=0; i<len; i+=partitionSize)
        {
            parts.add(string.substring(i, Math.min(len, i + partitionSize)));
        }
        return parts;
    }
}
