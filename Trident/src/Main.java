import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), s = sc.nextInt(), h = sc.nextInt();
        for(int a = 0; a < t;a++){
            for(int i = 0 ; i < 3; i++){
                System.out.print("*");
                if(i < 2){
                    for(int o = 0 ; o < s; o++){
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
        System.out.print("***");
        for(int i = 0 ; i < 2; i++){
            for(int o = 0; o < s; o++){
                System.out.print("*");
            }
        }
        System.out.println("");
        for(int i = 0 ; i < h ; i++){
            System.out.print(" ");
            for(int o = 0; o < s; o++){
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println("");
        }
    }
}
