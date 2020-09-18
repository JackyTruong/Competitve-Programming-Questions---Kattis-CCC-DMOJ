import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static String string;
    static int count;

    private static void LCP(String s, String t){
        int n = Math.min(s.length(), t.length());
        //System.out.println(s + " " + t + "these are the strings" + n);
        int repeats = 0;
        for(int i = 1; i <= n;i++){
            String tempS = s.substring(0,i);
            String tempT = t.substring(0,i);
            if(tempS.equals(tempT)){
                count--;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n =  nextInt();

        for(int i = 0 ; i < n; i++){
            string = next();
            //out.println(string);

            if(string.length() <= 1000){
                String[] suffix = new String[string.length()];
                for(int o = 0 ; o < string.length();o++){
                    suffix[o] = string.substring(o);
                }
                Arrays.sort(suffix);
                //System.out.println(Arrays.toString(suffix));
                count = suffix[0].length() + 1;

                for(int o = 1 ; o < string.length();o++){
                    LCP(suffix[o], suffix[o-1]);
                    count += suffix[o].length();
                    //System.out.println(lcp + " " + count);
                }
                out.println(count);
            }
            else{
                out.println(string.length()+1);
            }



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
