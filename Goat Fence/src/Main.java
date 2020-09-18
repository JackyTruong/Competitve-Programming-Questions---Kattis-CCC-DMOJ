import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static int findLowest(int n){
        int min1;
        int min2;
            min1 = n*2+2;
            for(int i = 2; i < Math.sqrt(n)+1;i++){
                if(((n/i)*2 + i*2) < min1 && n % i == 0){
                    min1 = ((n/i)*2 + i*2);
                }
            }
            min2 = 1;
            for(int i = 2; i < Math.sqrt(n)+1;i++){
                if(i*i >= n){
                    min2 = i*4;
                }
            }

        if(min1 <min2){
            return min1;
        }
        else{
            return min2;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int sqrt = (int)Math.sqrt(n);
        if(sqrt*sqrt == n){
            out.println(sqrt*4);
        }
        else{
            out.println(findLowest(n));
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
