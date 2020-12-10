import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int z = 0; z < 5 ; z++){
            int n = sc.nextInt();
            for(int i = 1 ; i <= n; i++){
                for(int o = 0 ; o < i; o++){
                    System.out.print("*");
                }
                System.out.println();
            }
            for(int i = n-1; i > 0; i--){
                for(int o = 0 ; o < i; o++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
