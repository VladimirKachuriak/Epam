import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int num_1 = num / 100;
        int num_2 = (num % 100 )/10;
        int num_3 = num % 10;
        if (num_1 >= num_2 && num_2 >= num_3) {
            System.out.println(num_1 + " " + num_2 + " " + num_3);
        } else if (num_1 >= num_3 && num_3 >= num_2) {
            System.out.println(num_1 + " " + num_3 + " " + num_2);
        } else if (num_2 >= num_1 && num_1 >= num_3) {
            System.out.println(num_2 + " " + num_1 + " " + num_3);
        } else if (num_2 >= num_3 && num_3 >= num_1) {
            System.out.println(num_2 + " " + num_3 + " " + num_1);
        } else if (num_3 >= num_2 && num_2 >= num_1) {
            System.out.println(num_3 + " " + num_2 + " " + num_1);
        } else if (num_3 >= num_2 && num_1 >= num_2) {
            System.out.println(num_3 + " " + num_1 + " " + num_2);
        }
    }
}
