package com.company.task2;

import static com.company.task1.Task1.SortEnum;

import java.util.Scanner;

import static com.company.task1.Task1.isSorted;


public class Task2 {
    public static void main(String[] args) {
        //int[] arr = fillDefault();
        int[] arr = fillArr();
        transform(arr, chooseSort());
        showArr(arr);
    }

    public static void transform(int[] arr, SortEnum sortEnum) {
        if (isSorted(arr, sortEnum)) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += i;
            }
        }
    }

    public static void showArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    public static int[] fillArr() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of array");
        int[] arr = new int[scan.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+1+"/"+arr.length);
            arr[i] = scan.nextInt();
        }

        return arr;
    }

    public static int[] fillDefault() {
        int[] arr = {15, 10, 3};
        return arr;
    }

    public static SortEnum chooseSort() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter method of sort: press 1 for ascending and 2 for descending");
        while(true) {
            switch (scan.nextInt()) {
                case 1:
                    return SortEnum.ASC;
                case 2:
                    return SortEnum.DESC;
            }
            System.out.println("Please, enter correct number");
        }
    }
}
