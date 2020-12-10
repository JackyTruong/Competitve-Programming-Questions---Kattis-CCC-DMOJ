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
        for(int i = 0 ; i < n ; i++){
            arr[i] = nextInt();
            out.print(arr[i] + " ");
        }
        out.println();
        boolean change = true;
        int spot = 0;
        while(change){
            change = false;
            for(int i = 0; i < n-1 && !change; i++,spot++){
                if(spot == n-1){
                    spot = 0;
                }
                if(arr[spot] > arr[spot+1]){
                    int temp = arr[spot];
                    arr[spot] = arr[spot+1];
                    arr[spot+1] = temp;
                    change = true;
                }
            }
            if(change){
                for(int i = 0 ; i < n; i++){
                    out.print(arr[i] + " ");
                }
                out.println();
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
