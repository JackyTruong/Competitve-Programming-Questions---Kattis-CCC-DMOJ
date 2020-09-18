import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        if(month == 2){
            if(day == 18){
                System.out.println("Special");
            }
            else if(day > 18){
                System.out.println("After");
            }
            else{
                System.out.println("Before");
            }
        }
        else if(month < 2){
            System.out.println("Before");
        }
        else{
            System.out.println("After");
        }
    }
}
