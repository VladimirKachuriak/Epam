package ua.univer.task05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayRectanglesTest {
    @Before
    public void setUp() {
        System.out.println("Before action started");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRectangle() {

        assertEquals("The result of adding is incorrect",false,new ArrayRectangles(new Rectangle(5,5),new Rectangle(1,2),new Rectangle(4,4)).addRectangle(new Rectangle(4,4)));
        ArrayRectangles rectangle1=new ArrayRectangles(2);
        assertEquals("The result of adding is incorrect",true,rectangle1.addRectangle(new Rectangle()));
        assertEquals("The result of adding is incorrect",true,rectangle1.addRectangle(new Rectangle(4,4)));
        assertEquals("The result of adding is incorrect",false,rectangle1.addRectangle(new Rectangle(2,1)));
        assertEquals("The result of adding is incorrect",false,rectangle1.addRectangle(new Rectangle(2,-1)));
    }

    @Test
    public void numberMaxArea() {
        assertEquals("Area result is wrong",0,new ArrayRectangles(new Rectangle(5,5),new Rectangle(1,2),new Rectangle(4,4)).numberMaxArea());
        assertEquals("Area result is wrong",2,new ArrayRectangles(new Rectangle(1,5),new Rectangle(1,2),new Rectangle(4,4)).numberMaxArea());
        assertEquals("Area result is wrong",1,new ArrayRectangles(new Rectangle(1,5),new Rectangle(22.4,5.4),new Rectangle(4,4)).numberMaxArea());
    }

    @Test
    public void numberMinArea() {
        assertEquals("Area result is wrong",1,new ArrayRectangles(new Rectangle(5,5),new Rectangle(1,2),new Rectangle(4,4)).numberMinArea());
        assertEquals("Area result is wrong",1,new ArrayRectangles(new Rectangle(1),new Rectangle(1,2),new Rectangle(4,4)).numberMinArea());
        assertEquals("Area result is wrong",2,new ArrayRectangles(new Rectangle(10,5),new Rectangle(22.4,5.4),new Rectangle()).numberMinArea());
    }

    @Test
    public void numberSquare() {
        assertEquals("Number of square in array is incorrect",2,new ArrayRectangles(new Rectangle(5,5),new Rectangle(2,1),new Rectangle(4,4)).numberSquare());
    }
}