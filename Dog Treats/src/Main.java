import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int third = sc.nextInt();
        int total = first + second*2 + third*3;
        if(total >= 10){
            System.out.println("happy");
        }
        else{
            System.out.println("sad");
        }
    }
}
