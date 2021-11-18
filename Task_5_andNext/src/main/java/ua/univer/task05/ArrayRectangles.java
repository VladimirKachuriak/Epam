package ua.univer.task05;

public class ArrayRectangles {
    private Rectangle[] rectangle_array;
    private int ilast;

    public ArrayRectangles(int n) {
        rectangle_array = new Rectangle[n];
        ilast = -1;
    }

    public ArrayRectangles(Rectangle... rect) {
        rectangle_array = rect;
        ilast = rect.length - 1;
    }

    public boolean addRectangle(Rectangle rect){
        if(rectangle_array.length-1>ilast){
            rectangle_array[++ilast]=rect;
            return true;
        }
        return false;
    }
    public int numberMaxArea(){
        int rect_index = 0;
        for (int i = 0; i < ilast; i++) {
            if(rectangle_array[rect_index].area()<rectangle_array[i+1].area()){
                rect_index = i+1;
            }
        }
        return rect_index;
    }
    public int numberMinArea(){
        int rect_index = 0;
        for (int i = 0; i < ilast; i++) {
            if(rectangle_array[rect_index].area()>rectangle_array[i+1].area()){
                rect_index = i+1;
            }
        }
        return rect_index;
    }
    public int numberSquare(){
        int counter = 0;
        for (int i = 0; i <= ilast; i++) {
            if(rectangle_array[i].isSquare())counter++;
        }
        return counter;
    }
}
