package ua.univer.task08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
class Word implements Comparable<Word> {
    private String word;
    private int frequency;

    public Word(String word, int frequency) {
        this.word = word;
        this.frequency=frequency;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Word o) {
        return Integer.compare(frequency, o.frequency);
    }
}
public class Part1 {
    private Word[] words = new Word[0];
    private int lindex = -1;

    private final int  MAX_OTPUT= 3;

    public Part1(String[] str) {
        for (int i = 0; i < str.length; i++) {
            add(str[i]);
        }
        Arrays.sort(words, Collections.reverseOrder());

        words = Arrays.copyOfRange(words,0,lindex>MAX_OTPUT-1 ? MAX_OTPUT:lindex+1);
        Arrays.sort(words, Collections.reverseOrder(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getWord().compareTo(o2.getWord());
            }
        }));
        for (int i = 0; i < (lindex>MAX_OTPUT-1 ? MAX_OTPUT:lindex+1); i++) {
            System.out.println(words[i].getWord() + "==>" + words[i].getFrequency());
        }
    }

    private void add(String word) {
        if (!isExist(word)) {
            words = Arrays.copyOf(words,words.length+1);
            words[++lindex] = new Word(word,1);
        }
    }

    private boolean isExist(String word) {
        for (int i = 0; i <= lindex; i++) {
            if (word.equals(words[i].getWord())) {
                words[i].setFrequency(words[i].getFrequency()+1);
                return true;
            }
        }
        return false;
    }
}
