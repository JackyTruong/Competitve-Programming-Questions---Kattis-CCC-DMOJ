import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out= new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> log = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            c.add(nextInt());
        }
        for(int i = 0 ; i < n; i++){
            log.add(nextInt());
        }
        Collections.sort(c);
        Collections.sort(log, Collections.reverseOrder());
        long cost = 0;
        for(int i = 0 ; i < n; i++){
            cost += c.get(i) * log.get(i);
        }
        out.println(cost);


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
