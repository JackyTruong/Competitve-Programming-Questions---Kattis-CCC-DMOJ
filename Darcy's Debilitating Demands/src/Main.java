import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int o = 0 ; o < t; o++){
            int n = nextInt();
            Integer[] inputs = new Integer[3];
            Integer[] output = new Integer[3];
            for(int i = 0; i < 3; i++){
                inputs[i] = nextInt();
            }
            for(int i = 2; i >= 0; i--){
                if(inputs[i] >= n){
                    output[i] = n;

                    n = 0;
                }
                else if(inputs[i] < n){
                    output[i] = inputs[i];

                    n -= inputs[i];
                }
            }
            if(n == 0){
                for(int i = 0; i < 3; i++){
                    out.print(output[i] + " ");
                }
            }
            else{
                out.println(-1);
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
