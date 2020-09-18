
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n, q;
    static long base, diff;
    static long[] arr;

    private static int amount(){
        int count = 0;
        boolean broke = false;
        long up = base+diff;
        long down = base - diff;
        for(int i = n - 1; i >= 0 && !broke; i--){
            if(up >= arr[i] && down <= arr[i]){
                count++;
            }
            else{
                broke = true;
            }
        }
        return count;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();q = nextInt();
        arr = new long[n];
        long largest = -Integer.MAX_VALUE;
        long smallest = Integer.MAX_VALUE;
        for(int i = 0 ; i < n; i++){
            arr[i] = nextLong();
            if(arr[i] < smallest){
                smallest = arr[i];
            }
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        for(int i = 0 ; i < q; i++){
            base = nextLong();
            diff = nextLong();
            if(base + diff >= largest && base-diff <= smallest){
                out.println(n);
            }
            else{
                out.println(amount());
            }
        }

        out.close();
    }

    private static String next()throws IOException {
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }

}
