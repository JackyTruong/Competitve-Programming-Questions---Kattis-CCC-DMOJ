import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br;
    private static PrintWriter out;
    private static StringTokenizer st;

    public static void main(String[] args)throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        double n = nextDouble(), m = nextDouble();
        double output = n/m;
        if(n%m == 0){
            out.println((int)output);
        }
        else{
            out.println(output);
        }
        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    private static double nextDouble()throws IOException{
        return Double.parseDouble(next());
    }
}
