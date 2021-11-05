package com.company.task2;


public class Main {
    public static void main(String[] args){
        int[] arr = {10, 10, 10, 10, 10};

        System.out.println(findDistance(arr));
    }

    private static int findDistance(int[] arr) {
        int max_start = 0;
        int max_end = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > arr[max_start]){
                max_start = i;
                max_end = i;
            }else if(arr[i] == arr[max_start]){
                max_end = i;
            }
        }
        return  max_end-max_start;
    }
}
