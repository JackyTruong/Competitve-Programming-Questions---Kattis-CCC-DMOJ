import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        double euclid = Math.PI*r*r;
        double taxicab = 2*r*r;
        System.out.printf("%.07f", euclid);
        System.out.println();
        System.out.printf("%.07f", taxicab);
    }
}
