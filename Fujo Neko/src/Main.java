
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int spotR, spotC, r, c;
    static char[][] map;

    private static boolean seeM(){
        for(int i = 0 ; i < c; i++){
            if(map[spotR][i] == 'X'){
                return true;
            }
        }
        for(int i = 0 ; i < r; i++){
            if(map[i][spotC] == 'X'){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        r = nextInt(); c =nextInt();
        map = new char[r][c];
        for(int i = 0 ; i < r;i++){
            map[i] = next().toCharArray();
        }
        int q = nextInt();
        for(int i = 0 ; i < q; i++){
            spotC = nextInt()-1;
            spotR = nextInt()-1;
            if(seeM()){
                out.println("Y");
            }
            else{
                out.println("N");
            }
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
