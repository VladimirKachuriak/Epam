package ua.univer.task09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.*;

public class Matrix {
    private static BufferedReader br;
    private static Logger logger = Logger.getLogger(Matrix.class.getName());

    static {
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            Handler fh = new FileHandler("src/main/java/ua/univer/task09/prog.log");
            fh.setFormatter(new SimpleFormatter());
            logger.setLevel(Level.INFO);
            logger.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double[][] matrix;

    public Matrix(int rows, int columns) {
        matrix = new double[rows][columns];
        logger.log(Level.INFO, Arrays.deepToString(matrix));
    }

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
        logger.log(Level.SEVERE, Arrays.deepToString(matrix));
    }

    public int getRows() {
        logger.log(Level.INFO, "getRows result" + matrix.length);
        return matrix.length;
    }

    public int getColumns() {
        logger.log(Level.INFO, "getColumns result" + matrix[0].length);
        return matrix[0].length;
    }

    public double[][] getMatrix() {
        logger.log(Level.INFO, Arrays.deepToString(matrix));
        return matrix;
    }

    public void recordDoubleByIndex(int rows, int columns, double number) throws MyException {
        if (isIndexesTrue(rows, columns)) {
            matrix[rows][columns] = number;
        } else {
            logger.log(Level.SEVERE, "rows = " + rows + " Columns" + columns + "MyException: Incorrect index");
            throw new MyException("Incorrect index");
        }
    }

    public double getDoubleByIndex(int rows, int columns) throws MyException {
        if (isIndexesTrue(rows, columns)) {
            return matrix[rows][columns];
        } else {
            logger.log(Level.SEVERE, "rows = " + rows + " Columns" + columns + "MyException: Incorrect index");
            throw new MyException("Incorrect index");
        }
    }


    public void addition(double[][] matrix) throws MyException {
        if (isMatrixEqual(matrix)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    this.matrix[i][j] += matrix[i][j];
                }
            }
        } else {
            logger.log(Level.SEVERE, "MyException: incompatible sizes of matrix in addition");
            throw new MyException("incompatible sizes of matrix");
        }
    }


    public void deduction(double[][] matrix) throws MyException {
        if (isMatrixEqual(matrix)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    this.matrix[i][j] -= matrix[i][j];
                }
            }
        } else {
            logger.log(Level.SEVERE, "MyException: incompatible sizes of matrix in deduction");
            throw new MyException("incompatible sizes of matrix");
        }
    }

    public void multiplication(double[][] matrix) throws MyException {
        if (isMatrixEqual(matrix)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    this.matrix[i][j] *= matrix[i][j];
                }
            }
        } else {
            logger.log(Level.SEVERE, "MyException: incompatible sizes of matrix in multiplication");
            throw new MyException("incompatible sizes of matrix");
        }
    }

    private boolean isIndexesTrue(int rows, int columns) {
        if (rows >= 0 && rows < matrix.length) {
            if (columns >= 0 && columns < matrix[rows].length) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatrixEqual(double[][] matrix) {
        if (this.matrix.length == matrix.length) {
            for (int i = 0; i < matrix.length; i++) {
                if (this.matrix[i].length != matrix[i].length) return false;
            }
            return true;
        }
        return false;
    }

}
