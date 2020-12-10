import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static boolean[] p;

    private static void sieve(){
        p = new boolean[1000001];
        for(int i = 0 ; i < 1000000; i++){
            p[i] = true;
        }
        for(int i = 2; i*i <= 1000000; i++){
            if(p[i]){
                for(int o = i*i; o <= 1000000; o += i){
                    p[o] = false;
                }
            }
        }
    }

    private static boolean isPal(int n){
        int sum = 0;
        int r;
        int temp = n;
        while(n > 0){
            r = n%10;
            sum *= 10;
            sum += r;
            n/=10;
        }
        return temp == sum;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        sieve();
        for(int z = 0 ;z < 5; z++){
            int n = nextInt();
            int m = nextInt();
            int count = 0;
            for(int i = n; i <= m ;i++){
                if(p[i]){
                    if(isPal(i)){
                        //System.out.println(i);
                        count++;
                    }
                }
            }
            out.println(count);
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }


}
