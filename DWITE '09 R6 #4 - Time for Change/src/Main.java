import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    private static int coins(int[] coins, int amount, int n){
        int[] f;
        int min, t;

        f = new int[amount+1];
        f[0] = 0;
        for(int i = 1; i <= amount; i++){
            min = 999999999;
            for(int o = 0 ; o < n; o++){
                t = i-coins[o];
                if(t >= 0 && f[t] >= 0 && f[t] < min){
                    min = f[t];
                }
            }
            if(min < 999999999){
                f[i] = min+1;
            }
            else{
                f[i] = -1;
            }
        }
        return f[amount];
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0 ;z < 5 ;z++){
            int amount = nextInt();
            int aCoin = nextInt();
            int[] coins = new int[aCoin];
            for(int i = 0; i < aCoin; i++){
                coins[i] = nextInt();
            }
            out.println(coins(coins, amount, aCoin));
        }



        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
