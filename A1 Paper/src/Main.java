import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int i = readInt();
        Integer[] papers = new Integer[i-1];
        double tape = 0.0;
        double num = Math.pow(2.0, -1.25);
        double second = Math.pow(2.0, -0.75);
        for(int o = 0; o < i - 1; o++){
            papers[o] = readInt();
        }
        double initial = 1;
        for(int o = 0; o < i-1 && initial != 0;o++){
                if(o % 2 == 1){
                    tape += initial * num;
                    num /= 2;
                }
                else{
                    tape += initial * second;
                    second /= 2;
                }
                initial *= 2;
                initial -= papers[o];
        }
        if(initial <= 0){
            out.println(tape);
        }
        else{
            out.println("impossible");
        }
        out.close();
    }
    static String next() throws IOException {
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());

        }
        return st.nextToken();
    }
    static int readInt()throws IOException {
        return Integer.parseInt(next());
    }
}

