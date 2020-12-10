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
            int highest = 1;
            int count = 1;
            int prev = 0;
            for(int i = 0 ; i < n; i++){
                arr[i] = nextInt();
            }
            for(int i = 0 ; i < n-1; i++){

                if(prev == arr[i]-arr[i+1]){
                    //System.out.println(arr[i] + " " + arr[i+1]);
                    count++;
                }
                else{
                    if(highest < count){
                        highest = count;
                    }
                    count = 2;
                    prev = arr[i]-arr[i+1];
                }
            }
            if(highest < count){
                highest = count;
            }
            out.println("Case #" + (z+1) + ": " + (highest));
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
