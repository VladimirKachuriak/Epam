package com.company.task4;

public class task4 {
    public static void main(String[] args) {
        System.out.println(progression(100,0.5f,20));
    }

    public static float progression(float a, float t, int alim) {
        if (a < alim) return 0;
        return a+progression(a * t, t, alim);
    }
}
