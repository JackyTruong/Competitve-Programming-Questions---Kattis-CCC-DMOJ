import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        Integer[] first = new Integer[n];
        Integer[] second = new Integer[n];
        int battles = 0;
        for(int i = 0 ; i < n;i++){
            first[i] = nextInt();
        }
        for(int i = 0 ; i < n;i++){
            second[i] = nextInt();
        }
        for(int i = 0 ; i < n;i++){
            if(first[i].equals(second[i])){
                battles++;
                if(i > 0 && first[i-1].equals(second[i-1])){
                    battles--;
                }
            }
        }
        out.println(battles);
        out.close();
    }

    private static String next()throws IOException {
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException {
        return Integer.parseInt(next());
    }

}
