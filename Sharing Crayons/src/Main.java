import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), m = nextInt();
        int[] arr = new int[n];
        int[] prefix = new int[n];
        arr[0] = nextInt();
        prefix[0] = arr[0];
        int count = 0;
        if(arr[0] % m == 0){
            count++;
        }
        for(int i = 1; i < n; i++){
            arr[i] = nextInt();
            if(arr[i] % m ==0){
                count++;
            }
            prefix[i] = arr[i] + prefix[i-1];
        }
        for(int i = 1; i < n;i ++){
            for(int o = 0; o < n-i; o++){
                if(o > 0){
                    if(prefix[o+i]%m == prefix[o-1]%m){
                        count++;
                    }
                }
                else{
                    if(prefix[o+i]%m==0){
                        count++;
                    }
                }
            }
        }
        out.println(count);


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
