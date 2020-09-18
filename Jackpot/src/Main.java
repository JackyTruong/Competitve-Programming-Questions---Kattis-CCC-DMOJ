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
        int n = nextInt();
        int w;
        for(int i = 0; i < n; i++){
            w = nextInt();
            Integer[] period = new Integer[w];
            for(int o = 0; o < w; o++){
                period[o] = nextInt();
            }
            Arrays.sort(period);
            int temp = findPeriod(period);
            if(temp == 1000000001){
                out.println("More than a billion.");
            }
            else{
                out.println(temp);
            }
        }
        out.close();
    }

    public static int findPeriod(Integer[] period){
        int base = period[period.length - 1];
        for(int i = 0; i < period.length-1; i++){
            while(base%period[i] != 0){
                base += period[period.length-1];
                if(base > 1000000000){
                    return 1000000001;
                }
                i = 0;
            }
        }
        return base;
    }

    public static String next()throws IOException{
        if(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    public static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
}
