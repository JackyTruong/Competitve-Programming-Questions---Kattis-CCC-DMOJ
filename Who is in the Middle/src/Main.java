import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] weights = new int[3];
        for(int i = 0 ; i < 3; i++){
            weights[i] = sc.nextInt();
        }
        Arrays.sort(weights);
        System.out.println(weights[1]);
    }
}
