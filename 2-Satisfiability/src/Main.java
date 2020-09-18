import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temp = sc.nextInt();
        System.out.print("$");
        System.out.printf("%.02f", temp/2);
        System.out.print(" $");
        System.out.printf("%.02f", (temp-(temp/2)));
    }
}
