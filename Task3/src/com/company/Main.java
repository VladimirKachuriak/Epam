package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int result = 0;
        while (num > 0) {
            if (num % 2 == 1) result += num % 10;
            num /= 10;
        }
        System.out.println(result);
    }
}
