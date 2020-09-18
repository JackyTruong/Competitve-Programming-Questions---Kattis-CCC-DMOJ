import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger num = sc.nextBigInteger();
        while(!num.isProbablePrime(1)){
            num = num.add(BigInteger.ONE);
        }
        System.out.println(num);
    }
}
