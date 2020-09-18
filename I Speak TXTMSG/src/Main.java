import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        String input = next();
        while(!input.equals("TTYL")){
            if(input.equals("CU")){
                out.println("see you");
            }
            else if(input.equals(":-)")){
                out.println("I'm happy");
            }
            else if(input.equals(":-(")){
                out.println("I'm unhappy");
            }
            else if(input.equals(";-)")){
                out.println("wink");
            }
            else if(input.equals("YW")){
                out.println("you're welcome");
            }
            else if(input.equals(":-P")){
                out.println("stick out my tongue");
            }
            else if(input.equals("(~.~)")){
                out.println("sleepy");
            }
            else if(input.equals("TA")){
                out.println("totally awesome");
            }
            else if(input.equals("CCC")){
                out.println("Canadian Computing Competition");
            }
            else if(input.equals("CUZ")){
                out.println("because");
            }
            else if(input.equals("TY")){
                out.println("thank-you");
            }
            else{
                out.println(input);
            }
            input = next();
        }
        out.println("talk to you later");

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
