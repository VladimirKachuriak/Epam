package com.company.task3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        int[][] arr = {{2, 4, 3, 3},
                {5, 7, 8, 5},
                {2, 4, 3, 3},
                {5, 7, 8, 5}};

        change(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }

    private static void change(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i>j){
                    arr[i][j]=0;
                }else if(i<j){
                    arr[i][j]=1;
                }
            }
        }
    }
}
