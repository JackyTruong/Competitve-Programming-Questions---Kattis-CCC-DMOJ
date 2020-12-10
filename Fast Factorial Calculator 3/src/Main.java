import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static BigInteger factorial(long n){
        BigInteger temp = BigInteger.ONE;
        for(int i = 2; i <= n; i++){
            temp = temp.multiply(BigInteger.valueOf(i));
        }
        return temp;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = nextLong(), p = nextLong();
        out.println(factorial(n).mod(BigInteger.valueOf(p)));
        //out.println(n%p);
        out.close();
    }

    private static String next()throws IOException {
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }

}
