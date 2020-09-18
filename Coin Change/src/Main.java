
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    private static int findCoins(int[] coins, int x, int n){
        int[] f;
        int min, temp;
        f = new int[x+1];
        f[0] = 0;
        for(int i = 1; i <= x; i++){
            min = 9999999;
            for(int o = 0 ; o < n; o++){
                temp = i-coins[o];
                if(temp >= 0 && f[temp] >= 0 && f[temp] < min){
                    min = f[temp];
                }
            }
            if(min < 9999999){
                f[i] = min+1;
            }
            else{
                f[i] = -1;
            }
        }
        return f[x];
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int x= nextInt();
        int n = nextInt();
        int[] coins = new int[n];
        for(int i = 0 ; i < n ;i++){
            coins[i] = nextInt();
        }
        int output = findCoins(coins, x, n);
        out.println(output);

        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st=  new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
