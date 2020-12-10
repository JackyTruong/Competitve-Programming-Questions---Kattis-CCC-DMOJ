import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0 ; z < t; z++){
            int n = nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n; i++){
                if(i + 2 <= n){
                    arr[i] = i+2;
                }
                else{
                    arr[i] = 1;
                }
            }
            for(int i = 0 ; i < n ; i++){
                out.print(arr[i] + " ");
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
