import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int map[][];
    static int steps[][];
    static int n, h;
    static boolean makeIt;
    static boolean[][] beenTo;

    private static void findWay(int row, int col, int prevE){
        if(!makeIt){
            if(row == n-1 && col == n-1){
                makeIt = true;
            }
            else if(row >= 0 && row < n && col >= 0 && col < n && !beenTo[row][col]){
                if(Math.abs(prevE - map[row][col]) <= h){
                    beenTo[row][col] = true;
                    findWay(row + 1, col, map[row][col]);
                    findWay(row - 1, col, map[row][col]);
                    findWay(row, col + 1, map[row][col]);
                    findWay(row, col - 1, map[row][col]);
                }
            }
        }

    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        h = nextInt();
        makeIt = false;
        beenTo = new boolean[n][n];
        map = new int[n][n];
        steps = new int[n][n];
        for(int i = 0 ; i < n; i++){
            for(int o = 0 ; o < n; o++){
                map[i][o] = nextInt();
                steps[i][o] = Integer.MAX_VALUE;
            }
        }
        findWay(0, 0, map[0][0]);
        if(makeIt){
            out.println("yes");
        }
        else{
            out.println("no");
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
