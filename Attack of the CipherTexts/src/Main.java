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
        String regular = br.readLine(); String regularCrypt = br.readLine(); String newCrypt = br.readLine();
        char[] replace = new char[27];
        for(int i = 0 ; i < regular.length(); i++){
            int temp = (int)regular.charAt(i);
            //System.out.println(temp);
            if(temp == 32){
                replace[0] = regularCrypt.charAt(i);
            }
            else{
                temp-=64;
                replace[temp] = regularCrypt.charAt(i);
            }
        }
        String sentence = "";
        System.out.println(Arrays.toString(replace));
        for(int i = 0 ; i < newCrypt.length();i++){
            boolean did = false;
            for(int o = 0; o < 27; o++){
                if(newCrypt.charAt(i) == replace[o]){
                    if(o == 0){
                        sentence += " ";
                        did = true;
                    }
                    else{
                        sentence += (char)(o+64);
                        did = true;
                    }
                }
            }
            if(!did){
                sentence += ".";
            }

        }
        out.println(sentence);


        out.close();
    }

    private static String next()throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

}
