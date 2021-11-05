package com.company.task1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] arr ={10, 5, 3, 4};
        arraySwap(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void arraySwap(int[] a){
        if(a[0]%2==0 && a[a.length-1]%2==0) {
            int temp = a[0];
            a[0] = a[a.length - 1];
            a[a.length - 1] = temp;
        }
    }
}
