
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    static BigInteger[][] M;

    private static BigInteger fib(BigInteger n){
        matpow(n.subtract(BigInteger.ONE));
        return M[0][0];
    }

    private static void matpow(BigInteger n){
        if(n.compareTo(BigInteger.ONE) == 1){
            matpow(n.divide(BigInteger.valueOf(2)));
            M = multiSelf();
        }
        if(n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ONE) == 0){
            M = multiplyMatrix();
        }
    }

    private static int getVersion() {
        String version = System.getProperty("java.version");
        if(version.startsWith("1.")) {
            version = version.substring(2, 3);
        } else {
            int dot = version.indexOf(".");
            if(dot != -1) { version = version.substring(0, dot); }
        } return Integer.parseInt(version);
    }

    private static BigInteger[][] multiSelf(){
        BigInteger[][] temp = new BigInteger[2][2];
        temp[0][0] = (M[0][0].multiply(M[0][0].mod(BigInteger.valueOf(1000000007))).add((M[0][1].multiply(M[1][0]))).mod(BigInteger.valueOf(1000000007)));
        temp[0][1] = (M[0][0].multiply(M[0][1].mod(BigInteger.valueOf(1000000007))).add((M[0][1].multiply(M[1][1]))).mod(BigInteger.valueOf(1000000007)));
        temp[1][0] = (M[1][0].multiply(M[0][0].mod(BigInteger.valueOf(1000000007))).add((M[1][1].multiply(M[1][0]))).mod(BigInteger.valueOf(1000000007)));
        temp[1][1] = (M[1][0].multiply(M[0][1].mod(BigInteger.valueOf(1000000007))).add((M[1][1].multiply(M[1][1]))).mod(BigInteger.valueOf(1000000007)));
        return temp;
    }

    private static BigInteger[][] multiplyMatrix(){
        BigInteger[][] temp = new BigInteger[2][2];
        temp[0][0] = M[0][0].add(M[1][0]);
        temp[0][1] = M[0][0];
        temp[1][0] = M[1][0].add(M[1][1]);
        temp[1][1] = M[1][0];
        return temp;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BigInteger temp = sc.nextBigInteger();
        M = new BigInteger[2][2];
        M[0][0] = BigInteger.ONE;
        M[0][1] = BigInteger.ZERO;
        M[1][0] = BigInteger.ZERO;
        M[1][1] = BigInteger.ONE;
        System.out.println(fib(temp));
    }

}
