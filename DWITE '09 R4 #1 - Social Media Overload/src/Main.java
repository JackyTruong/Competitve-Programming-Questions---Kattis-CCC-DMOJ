import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int z = 0 ;z < 5; z++){
            double n = sc.nextDouble();
            System.out.println((int)Math.round(9000.0/n));
        }
    }
}
