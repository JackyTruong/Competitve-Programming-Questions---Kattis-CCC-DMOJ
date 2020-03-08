import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int Tides[] = new int[n];
        for(int o = 0; o < n; o++){
            Tides[o] = sc.nextInt();
        }
        Arrays.sort(Tides);
        for(int a = 1; a < n/2+1; a++){
           System.out.println(Tides[(n/2)-a]);
           System.out.println(Tides[(n/2 - 1)+a]);
        }
        System.out.println(Arrays.toString(Tides));
    }
}
