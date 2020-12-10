import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < 5; i++){
            int[] a = new int[5];
            int[] b = new int[5];
            for(int z = 0 ; z < 5; z++){
                a[z] = sc.nextInt();
                b[z] = sc.nextInt();
            }
            int count = 0;
            for(int z = 0 ; z < 5; z++){
                int sum = sc.nextInt();
                if(a[z] + b[z] == sum){
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
