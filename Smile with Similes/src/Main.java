import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int a = nextInt(), n = nextInt();
        String[] adj = new String[a];
        String[] noun = new String[n];
        for(int i = 0 ; i < a; i++){
            adj[i] = next();
        }
        for(int i = 0 ; i < n; i++){
            noun[i] = next();
        }
        for(int i = 0 ; i < a; i++){
            for(int o = 0; o < n; o++){
                out.println(adj[i] + " as " + noun[o]);
            }
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }

}
