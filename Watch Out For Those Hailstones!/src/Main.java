import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static long nextNum(long i){
        if(i % 2 == 0){
            return i/2;
        }
        else if(i == 1){
            return 1;
        }
        else{
            return 3*i+1;
        }
    }

    public static long pattern(long i){
        if(nextNum(i) != 1){
            return i + pattern(nextNum(i));
        }
        else if(i != 1){
            return i+1;
        }
        else{
            return 1;
        }
    }


    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = nextLong();
        out.println(pattern(n));
        out.close();
    }

    static String next() throws IOException {
        if(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    static long nextLong()throws IOException{
        return Long.parseLong(next());
    }
}
