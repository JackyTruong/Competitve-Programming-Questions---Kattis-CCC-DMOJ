import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static boolean prefix(String A, String B){
        int minL = Math.min(A.length(), B.length());
        String tempA = A.substring(0, minL);
        String tempB = B.substring(0, minL);
        if(tempA.contains(tempB)){
            return true;
        }
        return false;
    }

    private static boolean suffix(String A, String B){
        int minL = Math.min(A.length(), B.length());
        String tempA = A.substring(A.length()-minL);
        String tempB = B.substring(B.length()-minL);
        if(tempA.contains(tempB)){
            return true;
        }
        return false;
    }

    private static boolean fix(String[] collection){
        for(int i = 0 ; i < 3; i++){
            for(int o = i+1; o < 3; o++){
                boolean tempPre = prefix(collection[i], collection[o]);
                boolean tempSuf = suffix(collection[i], collection[o]);
                if(tempPre || tempSuf){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        for(int i = 0 ; i < n; i++){
            String[] collection = new String[3];
            for(int o = 0 ; o < 3; o++){
                collection[o] = next();
            }
            if(fix(collection)){
                out.println("No");
            }
            else{
                out.println("Yes");
            }
        }


        out.close();
    }

    private static String next()throws IOException {
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
