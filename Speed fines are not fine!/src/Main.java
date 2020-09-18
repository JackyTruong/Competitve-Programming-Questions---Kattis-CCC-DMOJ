
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        int sped = sc.nextInt();
        int dif = sped - limit;
        if (dif <= 0) {
            System.out.println("Congratulations, you are within the speed limit!");
        } else if (dif <= 20) {
            System.out.println("You are speeding and your fine is $100.");
        } else if (dif <= 30) {
            System.out.println("You are speeding and your fine is $270.");
        } else {
            System.out.println("You are speeding and your fine is $500.");
        }
    }
}
