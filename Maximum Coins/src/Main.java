import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int sq;
    static long highest;
    static int[][] map;
    static boolean[][] beenTo;

    private static void fillDP(int row, int col, long count){
        if(row >= 0 && row < sq && col >= 0 && col < sq && !beenTo[row][col]){
            //System.out.println("Here " + row + " " + col + " " + count);
            count += map[row][col];
            if(count > highest){
                highest = count;
            }
            beenTo[row][col] = true;
            fillDP(row +1, col + 1, count);
            fillDP(row-1, col-1, count);
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        for(int z = 0; z < n ;z++){
            sq = nextInt();
            map = new int[sq][sq];
            highest = 0;
            for(int i = 0; i  < sq; i++){
                for(int o = 0 ; o < sq; o++){
                    map[i][o] = nextInt();
                }
            }
            for(int i = 0; i < sq; i++){
                beenTo = new boolean[sq][sq];
                fillDP(i, 0, 0);
            }
            for(int i = 0 ; i < sq; i++){
                beenTo = new boolean[sq][sq];
                fillDP(0, i, 0);
            }
            for(int i = 0 ; i < sq; i++){
                beenTo = new boolean[sq][sq];
                fillDP(i, sq-1, 0);
            }
            for(int i = 0 ; i < sq; i++){
                beenTo = new boolean[sq][sq];
                fillDP(sq-1, i, 0);
            }
            out.println("Case #" + (z+1) + ": " + highest);


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
