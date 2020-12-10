import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        int swiftCount = 0;
        int semapCount = 0;
        int days = 0;
        File file = new File("test.txt");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int swifts[] = new int[n];
        int semap[] = new int[n];
        for(int o = 0; o < n; o++){
            swifts[o] = sc.nextInt();
        }
        for(int a = 0; a < n; a++){
            semap[a] = sc.nextInt();
        }
        for(int b = 0; b < n; b++){
            swiftCount += swifts[b];
            semapCount += semap[b];
            if(semapCount == swiftCount){
                days = b + 1;
            }
        }
        System.out.println(days);
        System.out.println(Arrays.toString(swifts));
        System.out.println(Arrays.toString(semap));
    }
}
