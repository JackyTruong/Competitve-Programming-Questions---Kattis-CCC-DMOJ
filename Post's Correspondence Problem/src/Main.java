import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static String[] bArray, aArray;
    static Integer[] seq;
    static int m, n, k;

    private static boolean sequence(String A, String B, int count){
        if(count > m){
            return false;
        }
        else if(A.equals(B) && count > 0){
            return true;
        }
        else if(!equalString(A, B)){
            return false;
        }
        else{
            int i = 0;
            boolean possible = false;
            while(i < n && !possible){
                k = count;
                seq[k] = i;
                possible = sequence(A + aArray[i], B + bArray[i], count+1);
                i++;
            }
            return possible;
        }
    }
    private static boolean equalString(String A, String B){
        if(A.equals(B)){
            return true;
        }
        else if(A.length() < B.length()){
            return B.startsWith(A);
        }
        else if(A.length() > B.length()){
            return A.startsWith(B);
        }
        else{
            return false;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        m = nextInt();
        n = nextInt();
        aArray = new String[40];
        bArray= new String[40];
        seq = new Integer[40];
        String a = "";
        String b = "";
        for(int i = 0 ; i < n ;i++){
            aArray[i] = next();
        }
        for(int i = 0 ; i < n ;i++){
            bArray[i] = next();
        }
        if(sequence(a, b, 0)){
            out.println(k+1);
            for(int i = 0 ; i < k+1; i++){
                out.println(seq[i] + 1);
            }
        }
        else{
            out.println("No solution.");
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
