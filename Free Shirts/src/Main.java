import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < 10; i++){
            int n = nextInt(), m = nextInt(), d = nextInt();
            int temp = n;
            int count = 0;
            Integer[] events = new Integer[d];
            Arrays.fill(events, 0);
            for(int o = 0 ; o < m;o++){
                events[nextInt()-1]++;
            }
            for(int o = 0; o < d;o++){
                if(temp == 0){
                    count++;
                    temp = n;
                }
                if(events[o] > 0){

                    n+=events[o];
                    temp += events[o];
                }
                temp--;
            }
            out.println(count);
        }

        out.close();
    }

    private static String next()throws IOException {
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }
}
