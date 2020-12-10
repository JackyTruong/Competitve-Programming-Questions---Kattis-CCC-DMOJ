import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int a = 0; a <5 ;a++){
            int n  = nextInt();
            int i = 2;
            int count = 0;
            while(n != 1){
                if(n%i == 0){
                    n/=i;
                    i = 2;
                    count++;
                }
                else{
                    i++;
                }
            }
            if(count == 1){
                out.println(0);
            }
            else{
                out.println(count);
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
