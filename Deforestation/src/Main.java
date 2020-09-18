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
        int[] temp = new int[n];
        int[] prefix = new int[n];
        temp[0] = nextInt();
        prefix[0] = temp[0];
        for(int i = 1 ; i < n ;i++){
            temp[i] = nextInt();
            prefix[i] = prefix[i-1] + temp[i];
        }
        int q = nextInt();
        for(int i = 0 ; i < q; i++){
            int f = nextInt();
            int e = nextInt();
            int output;
            if(f-1 >= 0){
                output = prefix[e] - prefix[f-1];
            }else{
                output = prefix[e];
            }
            out.println(output);
        }





        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st= new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
