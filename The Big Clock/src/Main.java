import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt(), min = sc.nextInt();
        int add = sc.nextInt();
        min += add;
        while(min >= 60){
            min -=60;
            hour++;
            if(hour >= 24){
                hour -=24;
            }
        }
        System.out.println(hour + " " + min);
    }
}
