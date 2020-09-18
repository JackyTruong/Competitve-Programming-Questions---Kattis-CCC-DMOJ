import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        String word = next();
        while(!word.equals("quit!")){
            if(word.length() > 4){
                String temp = word.substring(word.length() - 2);
                char prev = word.charAt(word.length()-3);
                if(temp.equals("or") && (prev != 'a' && prev != 'e' && prev != 'i' && prev != 'o' && prev != 'u' && prev != 'y')){
                    String temp1 = word.substring(0, word.length()-2);
                    temp1 += "our";
                    System.out.println(temp1);
                }
                else{
                    System.out.println(word);
                }
            }
            else{
                System.out.println(word);
            }

            word = next();
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
