import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int num = nextInt();
        int C = 0;
        int N = 0;
        for(int i = 0; i < num; i++){
            int temp = nextInt()*nextInt();
            if(temp > C){
                C = temp;
            }
        }
        num = nextInt();
        for(int i = 0; i < num; i++){
            int temp = nextInt()*nextInt();
            if(temp > N){
                N = temp;
            }
        }
        if(N > C){
            out.println("Natalie");
        }
        else if(C > N){
            out.println("Casper");
        }
        else{
            out.println("Tie");
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
