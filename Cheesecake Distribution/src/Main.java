import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = nextLong();
        long[] people = new long[(int)n];
        long total = 0;
        long diff = 0;
        for(int i = 0 ; i < n; i++){
            people[i] = nextLong();
            total += people[i];
        }
        if(total%n == 0){
            total/=n;
            for(int i = 0 ; i < n; i++){
                if(total != people[i]){
                    diff += Math.abs(people[i]-total);
                }
            }
            out.println(diff/2);
        }
        else{
            out.println("Impossible");
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }

}
