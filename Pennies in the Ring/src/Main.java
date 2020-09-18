
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int r = nextInt();
        while(r != 0){
            int pennies = 0;
            double rS = r*r;
            for(int i = 1; i <= r; i++){
                pennies += (int)Math.sqrt(rS - (double)i*i)+1;

            }
            System.out.println(pennies*4+1);
            r = nextInt();
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
