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
        for(int z = 0 ;z < t; z++){
            int n = nextInt();
            int k = nextInt()-1;
            int s = nextInt()-1;
            int time = k;
            if(k - s < s + 1){
                time += k-s;
            }
            else{
                time += s + 1;
            }
            time += n-s;
            out.println("Case #" + (z+1) + ": " + time);
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
