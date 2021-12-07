package ua.univer.task09;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("fds");
        double[][] d={{1,1},{1,1}};
        Matrix matrix = new Matrix(new double[][]{{1,2},{3,4}});
        try {
            matrix.addition(new double[][]{{1,2},{3,4}});
        } catch (MyException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.deepToString(matrix.getMatrix()));
        try {
            matrix.getDoubleByIndex(-5,-6);
        } catch (MyException e) {
            e.printStackTrace();
        }

    }
}
