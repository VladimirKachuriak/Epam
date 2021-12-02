package ua.univer.task08;

public class Part3 {
    private static final int MAX_OTPUT = 3;
    public static void result(String[] str){
        for (int i = 0; i < str.length && i<MAX_OTPUT; i++) {
            System.out.println(new StringBuilder(str[i]).reverse().toString().toUpperCase());
        }
    }

}
