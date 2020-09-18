import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int mean = sc.nextInt();
        System.out.println(mean*2-first);
    }
}
