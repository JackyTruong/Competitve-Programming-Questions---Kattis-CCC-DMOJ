import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger temp = sc.nextBigInteger();
        if(temp.compareTo(BigInteger.ZERO) == -1){
            System.out.println("not");
        }
        else if(temp.isProbablePrime(1)){
            System.out.println("prime");
        }
        else{
            System.out.println("not");
        }
    }
}
