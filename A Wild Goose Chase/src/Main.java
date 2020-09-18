
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n, k;
    static int[] fox;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        k = nextInt();
        fox = new int[1000001];
        int increaseBy = 0;
        for(int i = 0; i < n; i++){
            int spot = nextInt();
            int statement = nextInt();
            if(statement == -1){
                increaseBy++;
                fox[spot]--;
            }
            else{
                fox[statement]++;
            }
        }
        boolean foundFox = false;
        for(int i = 1 ; i <= n; i++){
            if(fox[i]+increaseBy == k){
                out.print(i + " ");
                foundFox = true;
            }
        }
        if(!foundFox){
            out.println(-1);
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
