
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
        int n = nextInt();
        String[] arr = new String[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = next();
        }
        int centres = nextInt();
        int[] cent = new int[centres];
        int filled = 0;
        for(int i = 0 ; i < n; i++){
            if(filled < centres){
                cent[filled] = arr[i].length();
                filled++;
                out.println(filled);
            }
            else{
                int spot = 0;
                int lowest = Integer.MAX_VALUE;
                for(int o = 0 ; o < centres; o++){
                    if(cent[o] < lowest){
                        spot = o;
                        lowest = cent[o];
                    }
                }
                cent[spot] += arr[i].length();
                out.println(spot+1);
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
