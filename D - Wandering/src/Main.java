import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int[] arr = new int[n];
        int[] pref = new int[n+1];
        arr[0] = nextInt();
        pref[0] = arr[0];
        for(int i = 1 ; i < n; i++){
            arr[i] = nextInt();
            pref[i] = arr[i] + arr[i-1];
        }
        int firstNeg = 0;
        for(int i = 0 ; i < n+1; i++){
            if(pref[i] < 0){
                firstNeg = i;
            }
        }
        int spot = 0;
        int greatest = 0;
        for(int i = 1; i <= firstNeg+1; i++){
            for(int o = 0 ; o < i; o++){
                spot += arr[o];
                if(spot > greatest){
                    greatest = spot;
                }
            }
        }
        out.println(greatest);

        out.close();
    }

    private static String next()throws IOException {
        while(st==null||!st.hasMoreTokens()){
            st= new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
