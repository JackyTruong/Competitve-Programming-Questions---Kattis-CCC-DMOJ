import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();int k = nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = nextInt();
        }
        int[] otherCheck = arr.clone();
        boolean change = true;
        while(change){
            change = false;
            for(int i = 0 ; i < n ;i++){
                if(i + k < n && arr[i] > arr[i+k]){
                    int temp = arr[i];
                    arr[i] = arr[i+k];
                    arr[i+k] = temp;
                    change = true;
                }
            }
        }
        Arrays.sort(otherCheck);
        boolean nope = false;
        for(int i = 0 ; i < n && !nope; i++){
            if(arr[i] != otherCheck[i]){
                nope = true;
            }
            //System.out.println(arr[i] + " " + otherCheck[i]);
        }
        if(nope){
            out.println("NO");
        }
        else{
            out.println("YES");
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
