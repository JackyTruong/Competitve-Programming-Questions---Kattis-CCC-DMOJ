import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int same = 0;
        if(a == b){
            same++;
        }
        else if(a == c){
            same++;
        }
        if(b == c){
            same++;
        }
        boolean isTriangle = false;
        if(a+b+c == 180){
            isTriangle = true;
        }
        if(isTriangle){
            if(same == 1){
                System.out.println("Isosceles");
            }
            else if(same == 2){
                System.out.println("Equilateral");
            }
            else{
                System.out.println("Scalene");
            }
        }
        else{
            System.out.println("Error");
        }
    }
}
