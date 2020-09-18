import java.util.Scanner;

public class Main {

    private static void numIs(int n){
        int count = 1;
        for(int i = 2 ; i < Math.sqrt(n); i++){
            if(n % i == 0){
                count+=i;
                count+= n/i;
            }
        }
        if(count == n){
            System.out.println(n + " is a perfect number.");
        }
        else if(count < n){
            System.out.println(n + " is a deficient number.");
        }
        else{
            System.out.println(n + " is an abundant number.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0 ; i< num; i++){
            int temp = sc.nextInt();
            numIs(temp);
        }
    }
}
