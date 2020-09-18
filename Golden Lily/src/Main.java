import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int rows, cols;
    static int[][] map, filled;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        cols = nextInt(); rows = nextInt();
        map = new int[rows][cols];
        filled = new int[rows][cols];
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < cols; o++){
                map[i][o] = nextInt();
                filled[i][o] = 200000000;
            }
        }
        filled[0][0] = map[0][0];
        boolean change = true;
        while(change){
            change = false;
            for(int i = 0 ; i < rows; i++){
                for(int o = 0 ; o < cols; o++){
                    if(i-1 >= 0 && filled[i-1][o] + map[i][o] < filled[i][o]){
                        filled[i][o] = filled[i-1][o] + map[i][o];
                        change = true;
                    }
                    if(o-1 >= 0 && filled[i][o-1] + map[i][o] < filled[i][o]){
                        filled[i][o] = filled[i][o-1] + map[i][o];
                        change = true;
                    }
                    if(o+1 < cols && filled[i][o+1] + map[i][o] < filled[i][o]){
                        filled[i][o] = filled[i][o+1] + map[i][o];
                        change = true;
                    }
                }
            }
        }
        int spotR = nextInt();
        int spotC = nextInt();
        out.println(filled[spotC][spotR]);


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
