import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        double l = sc.nextDouble();
        double h = sc.nextDouble();
        System.out.println((int)Math.ceil(l*l*h/3));
    }
}
