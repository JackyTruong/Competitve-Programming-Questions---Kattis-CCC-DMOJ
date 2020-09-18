import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int watched = sc.nextInt();
        int[] clock = new int[4];
        clock[0] = 1;
        clock[1] = 2;
        int multiply = watched/1440;
        watched -= multiply*1440;
        int count = 0;
        for(int i = 0 ; i < watched; i++){
            clock[3]++;
            if(clock[3] == 10){
                clock[3] = 0;
                clock[2]++;
            }
            if(clock[2] == 6){
                clock[2] = 0;
                clock[1]++;
            }
            if(clock[0] == 1 && clock[1] == 3){
                clock[0] = 0;
                clock[1] = 1;
            }
            else if(clock[1] == 10){
                clock[0]++;
                clock[1] = 0;
            }
            int first = clock[0] - clock[1];
            int second = clock[1] - clock[2];
            int third = clock[2]- clock[3];
            if(clock[0] != 0){
                if(first == second && second == third){
                    count++;
                }
            }
            else{
                if(second == third){
                    count++;
                }
            }
        }
        count += multiply*62;
        System.out.println(count);
    }
}
