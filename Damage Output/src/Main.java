import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = nextLong(), m = nextLong();
        long[] prefix = new long[(int)n+1];
        prefix[1] = nextLong();
        for(int i = 2 ; i <= n; i++){
            prefix[i] = nextLong() + prefix[i-1];
        }
        int left = 0;
        int right = 0;
        long shortest = 500001;
        while(right <= n){

            long num = prefix[right] - prefix[left];
            //System.out.println("here " + num);
            if(num < m){
                right++;
            }
            else{
                if(right-left < shortest){
                    shortest = right-left;
                }
                left++;
            }
        }
        if(shortest == 500001){
            out.println(-1);
        }
        else{
            out.println(shortest);
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
