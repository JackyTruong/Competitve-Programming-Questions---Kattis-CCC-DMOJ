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
        int greatest = 0;
        for(int z = 0 ;z < n; z++){
            arr[z] = nextInt();
            if(arr[z] > greatest){
                greatest = arr[z];
            }
        }
        int largestK = 0;
        int num = 0;
        for(int i = 2; i <= greatest; i++){
            int countK = 0;
            for(int o = 0 ; o < n; o++){
                if(arr[o] % i == 0){
                    countK++;
                }
            }
            if(countK > largestK){
                largestK = countK;
                num = i;
            }
        }
        out.println(num);

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
