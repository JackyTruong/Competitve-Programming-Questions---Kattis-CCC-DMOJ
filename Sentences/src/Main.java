import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int num = nextInt();
        for(int z =0 ; z < num; z++){
            int numS = nextInt();
            int numA = nextInt();
            int numO = nextInt();
            String[] sub = new String[numS];
            String[] adj = new String[numA];
            String[] obj = new String[numO];
            for(int i = 0 ; i < numS; i++){
                sub[i] = br.readLine();
            }
            for(int i = 0 ; i < numA; i++){
                adj[i] = br.readLine();
            }
            for(int i = 0 ; i < numO ; i++){
                obj[i] = br.readLine();
            }
            for(int i = 0 ; i < numS; i++){
                for(int o = 0 ; o < numA; o++){
                    for(int a = 0; a < numO; a++){
                        out.println(sub[i] + " " + adj[o] + " " + obj[a] + ".");
                    }
                }
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
