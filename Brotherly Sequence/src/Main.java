
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[] seq;
    static int n;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        seq = new int[n];
        int[] hold = new int[n];
        int longest = 0;
        seq[0] = nextInt();
        for(int i = 1 ; i < n; i++){
            seq[i] = nextInt();
            if(Math.abs(seq[i-1]-seq[i]) <= 2){
                hold[i] = hold[i-1]+1;
            }
        }
        for(int i = 0 ; i < n; i++){
            if(hold[i] > longest){
                longest = hold[i];
            }
        }
        out.println(longest+1);




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
