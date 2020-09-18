import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pattern = new int[3];
        for(int i = 0; i < 3; i++){
            pattern[i] = sc.nextInt();
        }
        Arrays.sort(pattern);
        int diff1 = pattern[1] - pattern[0];
        int diff2 = pattern[2] - pattern[1];
        if(diff1 == diff2){
            System.out.println(pattern[2] + diff1);
        }
        else if(diff1 > diff2){
            System.out.println(pattern[1] - diff2);
        }
        else{
            System.out.println(pattern[1] + diff1);
        }
    }
}
