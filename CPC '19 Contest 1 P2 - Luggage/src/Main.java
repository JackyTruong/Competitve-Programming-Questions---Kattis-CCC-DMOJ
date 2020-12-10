import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[] arr;
    static int n, k, count;

    private static void findSubs(int l, int r){
        if(r-l+1 > count){
            if(Math.abs(arr[r] - arr[l]) > k){
                findSubs(l+1, r);
                findSubs(l, r-1);
            }
            else if(r-l+1 > count){
                //System.out.println(l + " " + r + " " + Math.abs(arr[r]-arr[l]));
                count = r-l+1;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
         n = nextInt(); k = nextInt();
        arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = nextInt();
        }
        Arrays.sort(arr);
        /*
        for(int i = 0 ; i < n; i++){
            out.println(arr[i]);
        }

         */

        count = 0;
        int left = 0;
        int right = n-1;
        findSubs(left, right);
        out.println(count);

        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
