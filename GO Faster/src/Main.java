import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[] add, sub;
    static int n;

    private static int findLowest(){
        int base = add[0];
        int num = 0;
        for(int i = 1; i < n-1; i++){
            num += sub[i];
        }
        if(num > base){
            return 0;
        }
        else{
            return base-num;
        }
    }

    private static int findHighest(){
        int first = add[0];
        int other = 0;
        for(int i = 1; i < n-1; i++){
            if(other - sub[i] < 0){
                sub[i] -= other;
                other = 0;
            }
            if(other == 0){
                first -= sub[i];
            }
            other += add[i];
        }
        return first;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        add = new int[n-1];
        sub = new int[n-1];
        for(int i = 0 ; i < n-1; i++){
            add[i] = nextInt();
            sub[i] = nextInt();
        }
        out.println(findLowest());
        out.println(findHighest());

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
