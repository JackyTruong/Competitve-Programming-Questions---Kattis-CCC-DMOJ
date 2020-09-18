import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, T, B;
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        T = nextInt();
        for(int i = 0 ; i < T; i++){
            int buyable = 0;
            N = nextInt();B = nextInt();
            Integer[] houses = new Integer[N];
            for(int o = 0 ;  o < N; o++){
                houses[o] = nextInt();
            }
            Arrays.sort(houses);
            for(int o = 0 ; o < N; o++){
                if(B >= houses[o]){
                    B-=houses[o];
                    buyable++;
                }
            }
            out.println("Case #" + (i+1) + ": " + buyable);
        }


        out.close();
    }

    private static String next()throws IOException {
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }


}
