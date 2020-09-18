import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n, k;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0;z < t; z++){
            n = nextInt();
            k = nextInt();
            String s = "";
            int i = 0;
            for(; i < k ; i++){
                s += "1";
            }
            for(;i < n; i++){
                s += "0";
            }
            int end = s.lastIndexOf("10");
            out.println("The bit patterns are");
            while(end >= 0){
                out.println(s);
                StringBuffer temp = new StringBuffer(s.substring(end+2));
                s = s.substring(0, end) + "01" + temp.reverse();
                end = s.lastIndexOf("10");
            }
            out.println(s);
            out.println("");
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
