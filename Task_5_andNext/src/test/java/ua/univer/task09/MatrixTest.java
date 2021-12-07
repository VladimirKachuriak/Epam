package ua.univer.task09;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void getRows() {
        Matrix matrix = new Matrix(new double[][]{{1,2},{3,4}});
        assertEquals(2,matrix.getRows());
    }

    @Test
    public void getColumns() {
        Matrix matrix = new Matrix(new double[][]{{1,2},{3,4}});
        assertEquals(2,matrix.getColumns());
    }

    @Test
    public void getMatrix() {
        double[][] a=new double[][]{{1,2},{3,4},{5,6}};
        Matrix matrix=new Matrix(a);
        assertArrayEquals(a,matrix.getMatrix());
    }


    @Test
    public void getDoubleByIndex() throws MyException {
        double[][] a=new double[][]{{1,2},{3,4},{5,6}};
        Matrix matrix=new Matrix(a);
        matrix.recordDoubleByIndex(1,1,10);
        assertEquals(10,matrix.getDoubleByIndex(1,1),0.001);

    }

    @Test
    public void addition() throws MyException {
        double[][] a=new double[][]{{1,2},{3,4},{5,6}};
        double[][] b=new double[][]{{1,1},{1,1},{1,1}};
        Matrix matrix=new Matrix(a);
        matrix.addition(b);
        assertArrayEquals(new double[][]{{2,3},{4,5},{6,7}},matrix.getMatrix());
    }

    @Test
    public void deduction() throws MyException {
        double[][] a=new double[][]{{1,2},{3,4},{5,6}};
        double[][] b=new double[][]{{1,1},{1,1},{1,1}};
        Matrix matrix=new Matrix(a);
        matrix.deduction(b);
        assertArrayEquals(new double[][]{{0,1},{2,3},{4,5}},matrix.getMatrix());
    }

    @Test
    public void multiplication() throws MyException {
        double[][] a=new double[][]{{1,2},{3,4},{5,6}};
        double[][] b=new double[][]{{2,2},{1,1},{2,2}};
        Matrix matrix=new Matrix(a);
        matrix.multiplication(b);
        assertArrayEquals(new double[][]{{2,4},{3,4},{10,12}},matrix.getMatrix());
    }
}