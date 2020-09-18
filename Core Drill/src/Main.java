import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), h = sc.nextInt();
        double temp = (Math.PI * r*r*h)/3.0;
        System.out.printf("%.02f", temp);
    }
}
