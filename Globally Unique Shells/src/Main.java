import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static PrintWriter out;
    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int r = nextInt();
        int l = nextInt();
        int[] rights = new int[1000000];
        for(int i = 0 ; i < r; i++){
            rights[nextInt()]++;
        }
        for(int i = 0 ; i < l; i++){
            int temp = nextInt();
            if(rights[temp] > 0){
                rights[temp]--;
                n--;
            }
        }
        out.println(n);


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
