import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int row = nextInt(), col = nextInt();
        char[][] map = new char[row][col];
        int count = 0;
        for(int i = 0 ; i < row; i++){
            map[i] = next().toCharArray();
            for(int o = 0 ; o < col-1; o++){
                if(map[i][o] == '.' && map[i][o+1] == '.'){
                    count++;
                }
            }
        }
        for(int o = 0 ; o < col ;o++){
            for(int i = 0 ; i < row-1; i++){
                if(map[i][o] == '.' && map[i+1][o] == '.'){
                    count++;
                }
            }
        }
        out.println(count);


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
