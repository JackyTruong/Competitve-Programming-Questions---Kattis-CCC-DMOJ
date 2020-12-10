import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int lp[];
    static ArrayList<Integer> primes;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        lp = new int[1000001];
        primes = new ArrayList<>();
        for (int i=2; i<=1000000; ++i) {
            if (lp[i] == 0) {
                lp[i] = i;
                primes.add(i);
            }
            for (int j=0; j< primes.size() && primes.get(j)<=lp[i] && i*primes.get(j)<=1000000; ++j)
                lp[i * primes.get(j)] = primes.get(j);
        }
        int n = nextInt();
        for(int z = 0 ;z < n; z++){
            int num = nextInt();
            ArrayList<Integer> output = new ArrayList<>();
            while(num > 1){
                for(int i = 0 ; i < primes.size(); i++){
                    if(num % primes.get(i) == 0){
                        num/=primes.get(i);
                        output.add(primes.get(i));
                        break;
                    }
                }
            }
            //Collections.sort(output);
            for(int i = 0 ; i < output.size(); i++){
                out.print(output.get(i) + " ");
            }
            out.println();
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
