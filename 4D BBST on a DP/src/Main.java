import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int length = nextInt();
        String base = next();
        String output =""+ base.charAt(0);
        for(int i = 1 ; i < length; i++){
                if(base.charAt(i) <= output.charAt(0)){
                    output = base.charAt(i) + output;
                }
                else{
                    output = output + base.charAt(i);
                }
        }
        out.println(output);

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
