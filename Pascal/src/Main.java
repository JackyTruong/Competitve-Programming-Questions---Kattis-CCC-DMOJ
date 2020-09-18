import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static long findDivisor(long n){
        long temp = 1;
        for(long i = 2; i < sqrt(n)+1; i++){
            if(n % i == 0){
                temp = i;
                break;
            }
        }
        return n/temp;
    }

    public static void main(String[] args)throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = nextLong();
        long counter = 0;
        counter += n-findDivisor(n);
        out.println(counter);

        out.close();
    }

    public static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    public static long nextLong()throws IOException{
        return Long.parseLong(next());
    }
}
