import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        double n = nextDouble();
        long baseTotal = 0;
        for(int i = 0 ; i < n; i++){
            baseTotal += nextDouble();
        }
        int other = nextInt();
        for(int i = 0; i < other; i++){
            double temp = nextDouble();
            baseTotal+= temp;
            n++;
            out.printf("%.03f",baseTotal/(n));
            out.println();
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

    private static double nextDouble()throws IOException{
        return Double.parseDouble(next());
    }

}
