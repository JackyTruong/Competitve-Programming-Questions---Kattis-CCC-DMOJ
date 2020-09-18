
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static PrintWriter out;
    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0 ; z < t; z++){
            int n = nextInt();
            String first = next();
            String second = next();
            String output = "";
            for(int i = n-1 ; i >= 0;i--){
                output += second.charAt(i);
                output += first.charAt(i);

            }
            out.println(output);
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
