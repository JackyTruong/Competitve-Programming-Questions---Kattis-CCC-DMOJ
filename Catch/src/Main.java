import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xA = sc.nextInt(), yA = sc.nextInt(), xB = sc.nextInt(), yB = sc.nextInt(), xC = sc.nextInt(), yC = sc.nextInt();
        int first = (int)(Math.pow(xA-xB, 2) + Math.pow(yA-yB, 2));
        int second = (int)(Math.pow(xA-xC, 2) + Math.pow(yA-yC, 2));
        int third = (int)(Math.pow(xC-xB, 2) + Math.pow(yC-yB, 2));
        first = Math.min(first, second);
        first = Math.min(first, third);
        System.out.println(first);
    }
}
