import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int d = nextInt();
        int n1 = 0;
        int n2 = 0;
        int diff = 0;
        boolean stop = false;
        while(diff != d && !stop && n1 <= 70 && n2 <= 70){
            while(diff < d){
                n2++;
                diff = (n2*n2) - (n1*n1);
                //out.println(diff + " first " + n2);
            }
            while(diff > d){
                n1++;
                diff = (n2*n2) - (n1*n1);
                //out.println(diff + " second " + n1);
                if(diff == 0){
                    stop = true;
                }
            }
        }
        if(!stop){
            out.println(n1 + " " + n2);
        }
        else{
            out.println("impossible");
        }

        out.close();
    }

    static String next()throws IOException {
        if(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
