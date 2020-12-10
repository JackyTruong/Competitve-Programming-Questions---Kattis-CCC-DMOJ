
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static char[][] map;
    static candySpot[][] dp;
    static int n;

    static class candySpot{
        int candies, count;
        public candySpot(int candies, int count){
            this.candies = candies;
            this.count = count;
        }
    }

    private static void fillDP(int row, int col, int candies, int count){
        if(row >= 0 && row < n && col >= 0 && col < n){
            if(map[row][col] == '*'){

            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0 ; z < 5; z++){
            n = nextInt();
            map = new char[n][n];
            dp = new candySpot[n][n];
            int billyR = 0, billyC = 0;
            for(int i = 0 ;i < n; i++){
                map[i] = next().toCharArray();
                for(int o = 0 ; o < n; o++){
                    if(map[i][o] == 'B'){
                        billyR = i;
                        billyC = o;
                    }
                    dp[i][o] = new candySpot(0, 9999999);
                }
            }
            dp[billyR][billyC] = new candySpot(0, 0);
        }



        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
