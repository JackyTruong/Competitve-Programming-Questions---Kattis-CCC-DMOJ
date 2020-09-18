import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int c, n, v, l;
    static int[] coins;

    private static int costAddition(){
        int[] dp = new int[c+1];
        int min, t;
        dp[0] = 0;
        for(int i = 1; i <= c; i++){
            min = 999999999;
            for(int o = 0 ; o < l; o++){
                t = i-coins[o];
                if(t >= 0 && dp[t] >= 0 && dp[t] < min){
                    min = dp[t];
                }
            }
            if(min < 999999999){
                dp[i] = min+1;
            }
            else{
                dp[i] = -1;
            }
        }
        return dp[c];
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt(); v = nextInt();
        coins = new int[n];
        for(int i = 0 ;i < n; i++){
            coins[i] = nextInt();
        }
        for(int i = 0; i < v; i++){
            c = nextInt(); l = nextInt();
            int temp = costAddition();
            out.println(temp);
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
