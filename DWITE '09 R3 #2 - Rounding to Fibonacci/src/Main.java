import java.util.Scanner;

public class Main {

    static long[] arr;

    private static void fib(int n){
        arr[n] = arr[n-1] + arr[n-2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new long[76];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= 45; i++){
            fib(i);
        }
        for(int z = 0 ; z < 5; z++){
            int n = sc.nextInt();
            int close = 0;
            for(int i = 0; i <= 45; i++){
                if(Math.abs(arr[close]-n) >= Math.abs(arr[i]-n)){
                    close = i;
                }
            }
            System.out.println(arr[close]);
        }
    }
}
