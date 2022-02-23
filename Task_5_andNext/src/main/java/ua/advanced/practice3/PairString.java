package ua.advanced.practice3;

import java.util.Arrays;

public class PairString {
    private String[] arr = new String[10];
    private int size = -1;

    public static void main(String[] args) {
        PairString pair = new PairString();
        PairString pair2 = new PairString();
        pair2.add("Zelen");
        pair.add("apple");
        pair.addByIndex("banana",5);
        pair.setByIndex("pankeke",0);
        System.out.println(pair);
        pair.addCollectionByIndex(pair2,2);
        System.out.println(pair);
        //System.out.println(pair.getByIndex(4));
    }
    public void add(String str) {
        addByIndex(str, size + 1);
    }

    public void addByIndex(String str, int index) {
        if (index % 2 == 1) index++;
        if (index > size + 1) {
            index = size + 1;
        }
        if (index + 2 > arr.length) increaseArray();
        if (index < size) moveWords(index, 2);
        arr[index] = str;
        arr[index + 1] = str;
        size += 2;

    }

    public void setByIndex(String str, int index) {
        if (index % 2 == 1) index++;
        if (index > size - 1) {
            index = size - 1;
        }
        // if (index + 2 > arr.length) increaseArray();
        arr[index] = str;
        arr[index + 1] = str;
    }

    public void addCollectionByIndex(PairString pair, int index) {
        if (index % 2 == 1) index++;
        if (index > size + 1) {
            index = size + 1;
        }
        if (size + pair.getSize() >= arr.length) increaseArray();
        if (index < size) moveWords(index, pair.getSize());
        for (int i = 0; i < pair.getSize(); i++) {
            this.arr[index] = pair.arr[i];
            this.size++;
            index++;
        }
    }

    public int getSize() {
        return size + 1;
    }

    public String getByIndex(int index) {
        if (index % 2 == 1) index--;
        if (index > size - 1) {
            index = size - 1;
        }
        // if (index + 2 > arr.length) increaseArray();
        return arr[index] + " " + arr[index + 1];
    }

    private void moveWords(int index, int step) {
       /* for (int i = size; i >= index; i--) {
            arr[i + step] = arr[i];
        }*/
        if (size + 1 - index >= 0) System.arraycopy(arr, index, arr, index + step, size + 1 - index);
    }


    private void increaseArray() {
        arr = Arrays.copyOf(arr, arr.length + 5);
    }

  /*  @Override
    public String toString() {
        return "PairString{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + (size + 1) +
                '}';
    }*/
        @Override
    public String toString() {
            if (arr == null)
                return "null";

            int iMax = size;
            if (iMax == -1)
                return "[]";

            StringBuilder b = new StringBuilder();
            b.append('[');
            for (int i = 0; ; i++) {
                b.append(String.valueOf(arr[i]));
                if (i == iMax)
                    return b.append(']').toString();
                b.append(", ");
            }
    }
}
