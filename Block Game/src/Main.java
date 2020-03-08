import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long i = readLong();
        long n = readLong();
        int plays = 0;
        while(i != 0 && n != 0){
            if(i > n){
                if(i % n == 0){
                    i = 0;
                }
                else if(n - (i - n * (i/n)) == 1 && i - n * (i/n) > n/2){
                    i -= n * (i/n);
                }
                else if(i/n < 2){
                    i -= n;
                }
                else{
                    i -= n*(i / n - 1);
                }
                plays++;
            }
            else{
                if(n % i == 0){
                    n = 0;
                }
                else if(i - (n - i * (n/i)) == 1 && n - i * (n/i) > i/2){
                    n -= i * (n/i);
                }
                else if(n/i < 2){
                    n -= i;
                }
                else{
                    n -= i*(n / i - 1);
                }
                plays++;
            }
        }
        if(plays % 2 != 0){
            out.println("win");
        }
        else{
            out.println("lose");
        }

        out.close();
    }

    static String next()throws IOException {
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static long readLong()throws IOException{
        return Long.parseLong(next());
    }
}
