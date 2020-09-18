import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int rows, cols, startR, startC, endR, endC;
    static char[][] map;
    static int[][] dp;
    static Queue<Cord> points;

    static class Cord{
        int r, c;
        public Cord(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        rows = nextInt();cols = nextInt();startR = nextInt(); startC = nextInt();endR = nextInt();endC = nextInt();
        map = new char[rows][cols];
        dp = new int[rows][cols];
        for(int i = 0 ; i < rows; i++){
            map[i] = next().toCharArray();
        }
        /*
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < cols; o++){
                System.out.print(dp[i][o] + " ");
            }
            System.out.println();
        }

         */
        int teles = nextInt();
        Cord[] tels = new Cord[teles];
        for(int i = 0 ; i < teles; i++){
            tels[i] = new Cord(nextInt(), nextInt());
        }
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < cols; o++){
                dp[i][o] = 9999999;
            }
        }
        dp[startR][startC] = 0;
        points = new LinkedList<>();
        points.offer(new Cord(startR, startC));
        while(!points.isEmpty()){
            Cord spot = points.poll();
            for(int i = -1; i <= 1; i++){
                for(int o = -1; o <= 1; o++){
                    if(Math.abs(i) + Math.abs(o) == 1){
                        int nextR = spot.r + i;
                        int nextC = spot.c + o;
                        if(nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && map[nextR][nextC] == 'O' && dp[spot.r][spot.c] + 1 < dp[nextR][nextC]){
                            dp[nextR][nextC] = dp[spot.r][spot.c] + 1;
                            points.offer(new Cord(nextR, nextC));
                        }
                    }

                }
            }
        }
        int output = 0;
        for(int i = 0 ; i < teles; i++){
            output = Math.max(output, dp[endR][endC] - dp[tels[i].r][tels[i].c]);
        }
        out.println(output);


        out.close();
    }

    private static String next()throws IOException{
        while(st == null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
