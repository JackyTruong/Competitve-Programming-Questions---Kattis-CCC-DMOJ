import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int spot = 1;
        while(n != 0){
            if(spot + n <= 100){
                spot += n;
            }
            if(spot >= 100){
                System.out.println("You are now on square " + spot);
                System.out.println("You Win!");
                break;
            }
            if(spot == 54){
                spot = 19;
            }
            else if(spot == 90){
                spot = 48;
            }
            else if (spot == 99){
                spot = 77;
            }
            else if(spot == 9){
                spot = 34;
            }
            else if(spot == 40){
                spot = 64;
            }
            else if(spot == 67){
                spot = 86;
            }
            System.out.println("You are now on square " + spot);
            n = sc.nextInt();
        }
        if(n == 0){
            System.out.println("You Quit!");
        }
    }
}
