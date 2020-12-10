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
        for(int z = 0; z < t; z++){
            int n = nextInt();
            int[] arr =new int[n+1];
            int[] spotT = new int[n+1];
            for(int i  = 0 ; i < n; i++){
                int temp = nextInt();
                arr[temp]++;
                spotT[temp] = i;
            }
            int spot = -1;
            for(int i = 1; i < n+1 && spot == -1; i++){
                if(arr[i] == 1){
                    spot = i;
                }
            }
            if(spot != -1){
                out.println(spotT[spot]+1);
            }
            else{
                out.println(-1);
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
