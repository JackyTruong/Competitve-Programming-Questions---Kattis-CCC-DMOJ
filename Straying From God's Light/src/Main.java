import java.io.*;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static char[][] map;
    static Movement[][] dp;
    static int n;

    static class Movement{
        int L, R, D;
        public Movement(int L, int R, int D){
            this.L = L;
            this.R = R;
            this.D = D;
        }
    }

    private static void fillDp(int row, int col, int L, int R, int D){
        if(row < n && col >= 0 && col < n){
            int base = dp[row][col].L*dp[row][col].L + dp[row][col].R * dp[row][col].R + dp[row][col].D * dp[row][col].D;
            int cost = R*R + L*L + D*D;
            if(cost < base && map[row][col] != '#'){
                dp[row][col] = new Movement(L, R, D);
                fillDp(row +1, col, L, R, D+1);
                fillDp(row, col + 1 , L, R+1, D);
                fillDp(row, col-1, L+1, R, D);
            }

        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(next());
        map = new char[n][n];
        dp = new Movement[n][n];
        for(int i = 0; i < n; i++){
            map[i] = next().toCharArray();
            for(int o = 0 ; o < n; o++){
                dp[i][o] = new Movement(9999, 9999, 9999);
            }
        }
        fillDp(0, 0, 0, 0, 0);
        int base = dp[n-1][n-1].L*dp[n-1][n-1].L + dp[n-1][n-1].R * dp[n-1][n-1].R + dp[n-1][n-1].D * dp[n-1][n-1].D;
        if(base == 299940003){
            out.println(-1);
        }
        else{
            out.println(base);
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
