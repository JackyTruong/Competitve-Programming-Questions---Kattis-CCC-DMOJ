import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int mult = sc.nextInt();
        int day = sc.nextInt();
        for(int i = 0 ; i < day; i++){
            start *= mult;
        }
        System.out.println(start);
    }
}
