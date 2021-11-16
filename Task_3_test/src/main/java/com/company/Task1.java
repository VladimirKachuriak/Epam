package com.company;

public class Task1 {
    public static enum SortEnum {ASC, DESC}

    public static void main(String[] args) {
        int[] arr = {1,  2,  3};
        System.out.println(isSorted(arr, SortEnum.ASC));
    }

    public static boolean isSorted(int[] arr, SortEnum sortEnum) {
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] > arr[i + 1] && sortEnum == SortEnum.ASC) return false;
            if (arr[i] < arr[i + 1] && sortEnum == SortEnum.DESC) return false;
        }
        return true;
    }
}
