
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static String converted;
    static char[] letter;
    static String[] code;
    static String binary;

    private static int spotAfter(int spot){
        for(int o = 0 ; o < code.length; o++){
            boolean front = true;
            for(int a = 0 ; a < code[o].length(); a++){
                if(spot+a < binary.length() && binary.charAt(spot+a) != code[o].charAt(a)){
                    front = false;
                    break;
                }
            }
            if(front){
                //System.out.println(letter[o] + " " + spot);
                converted += letter[o];
                spot += code[o].length();
                break;
            }
        }
        return spot-1;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        letter = new char[n];
        code = new String[n];
        converted = "";
        for(int i = 0 ; i < n; i++){
            letter[i] = next().charAt(0);
            code[i] = next();
        }
        binary = next();
        for(int i = 0 ; i < binary.length();i++){
            i = spotAfter(i);
        }
        out.println(converted);

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
