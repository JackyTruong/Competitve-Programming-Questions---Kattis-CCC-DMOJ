import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[][] dp;
    static char[][] map;

    static class Point{
        int row, col;
        int[][] dp;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
            dp = new int[10][19];
        }
    }

    private static void fillDP(int row, int col, int count){
        if(row >=0 && row < 10 && col >= 0 && col < 19 && count < dp[row][col] && map[row][col] != '#'){
            dp[row][col] = count;
            fillDP(row + 1, col , count+1);
            fillDP(row -1 , col, count+1);
            fillDP(row, col +1, count+1);
            fillDP(row, col-1, count+1);
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        map = new char[10][19];
        Point[] spots = new Point[12];
        for(int i = 0; i < 10; i++){
            map[i] = next().toCharArray();
            for(int o = 0 ; o < 19; o++){
                if(map[i][o] != '.' && map[i][o] != '#'){
                    spots[map[i][o]-65] = new Point(i,o);
                }
            }
        }
        for(int i = 0; i < spots.length;i++){
            dp = new int[10][19];
            for(int a = 0 ; a < 10; a++){
                for(int b = 0 ;  b < 19; b++){
                    dp[a][b] = 999999;
                }
            }
            fillDP(spots[i].row, spots[i].col, 0);
            spots[i].dp = dp;
        }
        for(int z = 0;z < 5; z++){
            String move = next();
            int count = 0;
            char place = move.charAt(0);
            for(int i = 1 ; i < move.length(); i++){
                int row = spots[move.charAt(i)-65].row;
                int col = spots[move.charAt(i)-65].col;
                count += spots[place-65].dp[row][col];
                place = move.charAt(i);
            }
            out.println(count);
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
