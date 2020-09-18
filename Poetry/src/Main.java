import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static void style(String[] finalSyl){
        if(finalSyl[0].equals(finalSyl[1]) && finalSyl[2].equals(finalSyl[1]) && finalSyl[3].equals(finalSyl[2])){
            out.println("perfect");
        }
        else if(finalSyl[0].equals(finalSyl[1]) && finalSyl[2].equals(finalSyl[3])){
            out.println("even");
        }
        else if(finalSyl[0].equals(finalSyl[2]) && finalSyl[1].equals(finalSyl[3])){
            out.println("cross");
        }
        else if(finalSyl[0].equals(finalSyl[3]) && finalSyl[1].equals(finalSyl[2])){
            out.println("shell");
        }
        else{
            out.println("free");
        }
    }

    private static String syl(String word){
        for(int i = word.length()-1; i >= 0; i--){
            if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u'){
                String temp = word.substring(i);
                return temp;
            }
        }
        return word;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        for(int i = 0 ; i < n ; i++){
            String[] finalSyl = new String[4];
            for(int o = 0; o < 4; o++){
                String temp = br.readLine();
                String word = temp.substring(temp.lastIndexOf(" ")+1);
                finalSyl[o] = syl(word.toLowerCase());
                //out.println(finalSyl[o]);
            }
            style(finalSyl);
        }

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
