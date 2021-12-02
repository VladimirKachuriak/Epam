package ua.univer.task08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;


public class Part2 {
    private String[] words = new String[0];
    private int lindex = -1;

    private final int MAX_OTPUT = 3;

    public Part2(String[] str) {
        for (int i = 0; i < str.length && i<MAX_OTPUT; i++) {
            add(findMaximum(str, i));
        }

    }
    public void show(){
        Arrays.sort(words, Collections.reverseOrder( new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        }));
        for (int i = 0; i < MAX_OTPUT && i<=lindex; i++) {
            System.out.println(words[i]+" ==> "+ words[i].length());
        }
        }


    private void add(String word) {
        if (!isExist(word)) {
            words = Arrays.copyOf(words,words.length+1);
            words[++lindex] = word;
        }
    }

    private boolean isExist(String word) {
        for (int i = 0; i <= lindex; i++) {
            if (word.equals(words[i])) {
                return true;
            }
        }
        return false;
    }
    private String findMaximum(String[] str, int start_index){
        int max_index=start_index;
        for (int i = start_index+1; i < str.length; i++) {
            if(str[max_index].length()<str[i].length() && !isExist(str[i]))max_index=i;
        }
        return str[max_index];
    }
}
