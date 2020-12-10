import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 5; i++){
            int n = sc.nextInt();
            int count = n;
            for(int a = 2; a < n; a++){
                for(int b = a; b * a <= n; b++){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
