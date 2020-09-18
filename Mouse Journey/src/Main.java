
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int rows, col;
    static int[][] map;

    private static void ways(){
        map[0][0] = 1;
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < col; o++){
                if(map[i][o] != -1 && i-1 >= 0){
                    if(map[i-1][o] != -1){
                        map[i][o] += map[i-1][o];
                    }
                }
                if(map[i][o] != -1 && o-1 >= 0){
                    if(map[i][o-1] != -1){
                        map[i][o] += map[i][o-1];
                    }

                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        rows = nextInt();col = nextInt();
        map = new int[rows][col];
        int numCats = nextInt();
        for(int i = 0 ; i < numCats; i++){
            int tempA = nextInt()-1;
            int tempB = nextInt()-1;
            map[tempA][tempB] = -1;
        }
        ways();
        out.println(map[rows-1][col-1]);


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
