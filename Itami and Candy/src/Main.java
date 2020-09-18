import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n, rX;
    static int[] count;
    static ArrayList<Integer> primes;

    private static void sieve(){
        for(int i = 2; i <= n; i++){
            if(count[i] == 0){
                count[i] = i;
                primes.add(i);
            }
            for(int o = 0 ;o < primes.size() && primes.get(o) <= count[i] && i*primes.get(o)<=n;o++){
                count[i*primes.get(o)] = primes.get(o);
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();rX = nextInt();count = new int[n+1];primes = new ArrayList<>();
        sieve();
        int count = 0;
        for(int i = 0 ; i < primes.size(); i++){
            int temp = n-primes.get(i);
            int num = temp/rX;
            if(num*rX == temp){
                count++;
            }
            else{
                count+=2;
            }
            count+= (num)*2;
        }
        out.println(count);

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
