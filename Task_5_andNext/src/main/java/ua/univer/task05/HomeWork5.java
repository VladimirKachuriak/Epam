package ua.univer.task05;

public class HomeWork5 {
    public static void main(String[] args) {
        ArrayRectangles arr = new ArrayRectangles(new Rectangle(),new Rectangle(5,5));

        System.out.println(arr.numberMinArea());
        System.out.println(arr.numberSquare());
        System.out.println(arr.addRectangle(new Rectangle(3,3)));
        try {
            Rectangle rect = new Rectangle(-1, 5);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

}
