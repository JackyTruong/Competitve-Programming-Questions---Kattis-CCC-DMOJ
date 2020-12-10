import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[][] map;
    static int rows, cols, n, m, illum;

    private static void fillSurrounding(int row, int col){
        int left = 0;
        while(col + left >= 0 && map[row][col+left] != -1){
            if(map[row][col+left] != 1 && map[row][col+left] != 2){
                map[row][col+left] = 2;
                illum++;
            }
            left--;
        }
        int right = 0;
        while(col + right < cols && map[row][col + right] != -1){
            if(map[row][col+right] != 1 && map[row][col+right] != 2){
                map[row][col+right] = 2;
                illum++;
            }
            right++;
        }
        int down = 0;
        while(row + down < rows && map[row+down][col] != -1){
            if(map[row+down][col] != 1 && map[row+down][col] != 2) {
                map[row + down][col] = 2;
                illum++;
            }
            down++;
        }
        int up = 0;
        while(row + up >= 0 && map[row+up][col] != -1){
            if(map[row+up][col] != 1 && map[row+up][col] != 2){
                map[row+up][col] = 2;
                illum++;
            }
            up--;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        rows = nextInt(); cols = nextInt(); n = nextInt(); m = nextInt();
        map = new int[rows][cols];
        illum = n;
        for(int i = 0; i < n; i++){
            map[nextInt()-1][nextInt()-1] = 1;

        }
        for(int i = 0 ; i < m; i++){
            map[nextInt()-1][nextInt()-1] = -1;
        }
        for(int i = 0; i < rows; i++){
            for(int o = 0 ; o < cols; o++){
                if(map[i][o] == 1){
                    fillSurrounding(i, o);
                }
            }
        }

        out.println(illum);

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
