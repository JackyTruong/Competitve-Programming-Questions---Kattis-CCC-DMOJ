import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static boolean[] p;

    private static void sieve(){
        p = new boolean[100001];
        for(int i = 0 ; i < 100000; i++){
            p[i] = true;
        }
        for(int i = 2; i*i <= 100000; i++){
            if(p[i]){
                for(int o = i*i; o <= 100000; o += i){
                    p[o] = false;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        sieve();
        for(int z = 0; z < 5; z++){
            int n = nextInt();
            p[1] = false;
            int count = 0;
            for(int i = 0; i <= n; i++){
                if(p[i]){
                    count += i;
                }
            }
            out.println(count);
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st= new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
