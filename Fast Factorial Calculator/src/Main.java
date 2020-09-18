import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    /*
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
*/
    public static void main(String[] args)throws IOException {
        Scanner sc  = new Scanner(System.in);
        //br = new BufferedReader(new InputStreamReader(System.in));
        //out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = sc.nextLong();
        for(int i = 0 ; i < n; i++){
            BigInteger num = sc.nextBigInteger();
            //System.out.println(num);
            if(num.compareTo(BigInteger.valueOf(33)) == 1 ){
                System.out.println(0);
            }
            else{
                BigInteger output = BigInteger.ONE;
                for(BigInteger o = BigInteger.valueOf(2); o.compareTo(num) == -1 || o.compareTo(num) == 0; o = o.add(BigInteger.ONE)){
                    output = output.multiply(o);
                }
                output = output.mod(BigInteger.valueOf((long)Math.pow(2,32)));
                System.out.println(output);
            }
        }

        //out.close();
    }
/*
    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }


 */
}
