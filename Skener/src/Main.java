import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int rows = nextInt(), cols = nextInt(), MR = nextInt(), MC = nextInt();
        char[][] zoom = new char[rows][cols];
        for(int i = 0 ; i < rows; i++){
            zoom[i] = next().toCharArray();
        }
        for(int i = 0 ; i < rows; i++){
            for(int a = 0 ; a < MR; a++){
                for(int o = 0 ; o < cols; o++){
                    for(int b = 0 ; b < MC; b++){
                        System.out.print(zoom[i][o]);
                    }
                }
                System.out.println();
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
