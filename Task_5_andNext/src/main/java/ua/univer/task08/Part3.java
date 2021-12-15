package ua.univer.task08;

import java.util.Arrays;

public class Part3 {
    private static String[] words = new String[0];
    private static final int MAX_OTPUT = 3;

    public static void result(String[] str) {
        int counter = 0;
        for (int i = 0; i < str.length && MAX_OTPUT > counter; i++) {
            if (isExist(str[i])) {
                System.out.println(new StringBuilder(str[i]).reverse().toString().toUpperCase());
                counter++;
            } else {
                add(str[i]);
            }
        }
    }

    private static void add(String word) {
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
    }

    private static boolean isExist(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                return true;
            }
        }
        return false;
    }


}
