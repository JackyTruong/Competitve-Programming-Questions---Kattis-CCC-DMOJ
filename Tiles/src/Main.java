import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int w = sc.nextInt(), l = sc.nextInt(), t = sc.nextInt();
        System.out.println((w/t)*(l/t));
    }
}
