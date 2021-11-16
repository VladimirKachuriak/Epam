package com.company;

public class Task3 {
    public static void main(String[] args) {
       System.out.println(progression(5,3,4));
    }

    public static int progression(int a, int t, int n) {
        if(n<=0)return 0;
        if(n==1)return a;
        return a*progression(a+t, t, n-1);
    }
}



