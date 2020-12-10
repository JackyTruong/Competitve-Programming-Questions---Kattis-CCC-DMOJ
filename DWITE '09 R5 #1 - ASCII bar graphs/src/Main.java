import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int z = 0 ;z < 5; z++){
            int temp = sc.nextInt();
            if(temp < 0){
                for(int i = 0 ; i < 5+temp; i++){
                    System.out.print("-");
                }
                for(int i = 0 ; i < Math.abs(temp); i++){
                    System.out.print("*");
                }
                System.out.print("|");
                for(int i = 0; i < 5; i++){
                    System.out.print("-");
                }
                System.out.println();
            }
            else{
                for(int i = 0 ; i < 5; i++){
                    System.out.print("-");
                }
                System.out.print("|");
                for(int i = 0; i < temp; i++){
                    System.out.print("*");
                }
                for(int i = 0 ; i < 5-temp; i++){
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }
}
