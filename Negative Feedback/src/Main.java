import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double V = sc.nextDouble(), Rf = sc.nextDouble(), Rg = sc.nextDouble();
        System.out.println(V*(1 + (Rf/Rg)));
    }
}
