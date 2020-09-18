import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i < n; i+=2){
            for(int o = 0 ; o < i; o++){
                System.out.print("*");
            }
            int temp = n*2-i*2;
            for(int o = 0 ; o < temp;o++){
                System.out.print(" ");
            }
            for(int o = 0 ; o < i; o++){
                System.out.print("*");
            }
            System.out.println("");
        }
        for(int i = 0; i < n*2;i++){
            System.out.print("*");
        }
        System.out.println("");
        for(int i = n-2; i >= 1; i-=2){
            for(int o = 0 ; o < i; o++){
                System.out.print("*");
            }
            int temp = n*2-i*2;
            for(int o = 0 ; o < temp;o++){
                System.out.print(" ");
            }
            for(int o = 0 ; o < i; o++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
