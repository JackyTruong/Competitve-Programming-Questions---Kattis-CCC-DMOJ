import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = nextLong();
        for(int o = 0 ; o < n; o++){
            long a = nextLong();
            boolean found = false;
            long num = 0;
            for(long i = 192; i < Long.MAX_VALUE && !found; i+= 250){
                if(i > a){
                    found = true;
                    num = i;
                }
            }

            out.println(num);
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
