import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    private static long gcd(long first, long second){
        if(first == 0){
            return second;
        }
        return gcd(second%first, first);
    }

    private static long arrGCD(long[] arr, long n){
        long output = arr[0];
        for(int i = 1; i < n; i++){
            output = gcd(arr[i], output);
            if(output == 1){
                return output;
            }
        }
        return output;
    }

    private static long primeNum(long num){
        long max = -1;
        while(num%2 == 0){
            max = 2;
            num /= 2;
        }

        for(int i = 3; i <= Math.sqrt(num); i+=2){
            while(num%i == 0){
                max = i;
                num /= i;
            }
        }
        if(num > 2){
            max = num;
        }
        return max;

    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = nextLong();
        long[] arr = new long[(int)n];
        for(int i = 0 ; i < n; i++){
            arr[i] = nextLong();
        }
        long GCD = arrGCD(arr, n);
        GCD = primeNum(GCD);
        if(GCD != -1){
            out.println(GCD);
        }
        else{
            out.println("DNE");
        }



        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }

}
