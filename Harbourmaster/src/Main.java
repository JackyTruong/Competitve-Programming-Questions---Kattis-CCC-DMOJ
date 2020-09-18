import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static double lowest;
    static int n;
    static double C, S, P;
    static CrewM[] m;

    static class CrewM{
        int C, S, P;
        public CrewM(int C, int S, int P){
            this.C = C;
            this.S = S;
            this.P = P;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        C =nextInt(); S =nextInt(); P = nextInt();n = nextInt();
        m = new CrewM[n];
        for(int i = 0; i < n; i++){
            m[i] = new CrewM(nextInt(), nextInt(), nextInt());
        }
        int temp = Math.min(n, 5);
        out.printf("%.01f", lowest*100);


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
