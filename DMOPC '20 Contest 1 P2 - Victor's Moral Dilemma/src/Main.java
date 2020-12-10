import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int a = nextInt();
        int d = nextInt();
        int[] arr = new int[a];
        for(int i = 0 ; i < a ; i++){
            arr[i] = nextInt();
        }
        for(int i = 0 ; i < d; i++){
            int n = nextInt();
            int sumF = 0;
            int sumS = 0;
            int[] arrF = new int[n];
            int[] arrS = new int[arr.length-n];
            for(int o = 0 ; o < n; o++){
                sumF += arr[o];
                arrF[o] = arr[o];
            }

            for(int o = 0; o < arr.length-n; o++){
                sumS += arr[o+n];
                arrS[o] = arr[o+n];
            }
            if(sumF >= sumS){
                arr = arrS;
                out.println(sumF);
            }
            else{
                arr = arrF;
                out.println(sumS);
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
