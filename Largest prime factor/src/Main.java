import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger temp = BigInteger.valueOf((long)600851475143.0);
        BigInteger factor = BigInteger.ONE;
        boolean found = false;
        for(;factor. temp; ){
            if(factor.isProbablePrime(1) && temp.mod(factor).equals(BigInteger.ZERO)){
                found = true;
                System.out.println(factor);
            }
            else{
                factor =factor.add(BigInteger.ONE);
            }
        }

    }
}
