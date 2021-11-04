import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        num = scan.nextInt();
        if (num > 0) {
            System.out.println(num * num);
        } else if (num < 0) {
            System.out.println(-1 * num);
        } else {
            System.out.println(num);
        }
    }
}
