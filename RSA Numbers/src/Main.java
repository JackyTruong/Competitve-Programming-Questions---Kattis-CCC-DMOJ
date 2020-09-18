import java.util.Scanner;

public class Main {

    private static boolean RSA(int n){
        int divisors = 0;
        for(int i = 1 ; i <= Math.sqrt(n);i++){
            if(n % i == 0){
                divisors += 2;
                //System.out.println("this is the n " + n + " this is i " + i);
            }
            if(i*i == n){
                divisors--;
            }
        }
        if(divisors == 4){
            //System.out.println(n);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lower = sc.nextInt(), upper = sc.nextInt();
        int count = 0;
        for(int i = lower; i <= upper; i++){
            if(RSA(i)){
                count++;
            }
        }
        System.out.println("The number of RSA numbers between " + lower + " and " + upper + " is " + count);
    }
}
