import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int z = 0; z < 5; z++){
            int n = sc.nextInt();
            int[] arr = new int[n+2];
            for(int i = 1 ; i <= n; i++){
                int temp = sc.nextInt();
                arr[temp] = temp;
            }
            for(int i = 1 ; i < n+2; i++){
                if(arr[i] != i){
                    System.out.println(i);
                }
            }

        }
    }
}
