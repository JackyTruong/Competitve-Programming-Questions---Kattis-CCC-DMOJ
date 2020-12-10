import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int z = 0 ; z < 5; z++){
            int n = sc.nextInt();
            ArrayList<Integer> primes = new ArrayList<>();
            while(n != 1){
                for(int i = 2; i <= n ; i++){
                    if(n % i == 0){
                        n /= i;
                        if(!primes.contains(i)){
                            primes.add(i);
                        }
                    }
                }
            }
            if(primes.size() == 3){
                System.out.println("valid");
            }
            else{
                System.out.println("not");
            }

        }
    }
}
