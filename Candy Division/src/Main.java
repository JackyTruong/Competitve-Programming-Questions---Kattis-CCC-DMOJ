import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long n =  readLong();
        ArrayList<Long> num = new ArrayList<>();
        for(long i = 1; i <= Math.sqrt(n);i++){
            if(n % i == 0){
                num.add(i);
                if(n/i != i){
                    num.add(n/i);
                }
            }
        }
        Collections.sort(num);
        for(int i = 0; i < num.size(); i++){
            out.print(num.get(i)-1 + " ");
        }



        out.close();
    }

    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static long readLong()throws IOException{
        return Long.parseLong(next());
    }
}
