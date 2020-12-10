import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;


    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[200002];
        int n = nextInt();
        int brokeUpTo = 0;
        for(int i = 0 ; i < n; i++){
            arr[nextInt()] = 1;
            for(int o = brokeUpTo ; o < 200002; o++){
                if(arr[o] == 0){
                    brokeUpTo = o;
                    out.println(o);
                    break;
                }
            }
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
