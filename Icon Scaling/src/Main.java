import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int increase = nextInt();
        for(int i = 0 ; i < increase; i++){
            for(int o = 0 ; o < increase; o++){
                out.print("*");
            }
            for(int o = 0 ; o < increase; o++){
                out.print("x");
            }
            for(int o = 0 ; o < increase; o++){
                out.print("*");
            }
            out.println("");
        }
        for(int i = 0 ; i < increase; i++){
            for(int o = 0 ; o < increase; o++){
                out.print(" ");
            }
            for(int o = 0 ; o < increase*2; o++){
                out.print("x");
            }
            out.println("");
        }
        for(int i = 0 ; i < increase;i++){
            for(int o = 0 ; o < increase; o++){
                out.print("*");
            }
            for(int o = 0 ; o < increase; o++){
                out.print(" ");
            }
            for(int o = 0 ; o < increase; o++){
                out.print("*");
            }
            out.println("");
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
