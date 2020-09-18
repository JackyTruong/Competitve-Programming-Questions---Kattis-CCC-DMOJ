
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        double h = 0;
        for(int i = 0 ; i < n; i++){
            double s = nextDouble(), x = nextDouble();
            double t = nextDouble();
            h += t*(s*Math.sin(Math.toRadians(x)));
        }

        double v = Math.sqrt(2.0*9.8*h);
        out.println(Math.round(v));

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

    private static double nextDouble()throws IOException{
        return Double.parseDouble(next());
    }

}
