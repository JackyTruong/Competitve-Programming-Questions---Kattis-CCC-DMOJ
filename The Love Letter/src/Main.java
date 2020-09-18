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
        int n = nextInt(), L = nextInt();
        String temp = "";
        StringBuffer output = new StringBuffer();
        while(temp.length() < n){
            temp += next();
            temp += " ";

        }
        for(int i = 0; i < temp.length();i++){
            if(temp.charAt(i) != ' ') {
                if (Character.isUpperCase(temp.charAt(i))) {
                    output.append((char)(((int)temp.charAt(i) + L - 65)%26 + 65));
                }
                else{
                    output.append((char)(((int)temp.charAt(i) + L - 97)%26 + 97));
                }
            }
            else{
                output.append(' ');
            }
        }
        out.println(output);
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
