import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int sX = nextInt(), sY = nextInt();
        int mX = nextInt(), mY = nextInt();
        int spotX = 0, spotY = 0;
        while(mX != 0 || mY != 0){
            if(mX > 0){
                spotX = Math.min(sX, spotX+mX);
            }
            else{
                spotX = Math.max(0, spotX+mX);
            }
            if(mY > 0){
                spotY = Math.min(sY, spotY+mY);
            }
            else{
                spotY = Math.max(0, spotY + mY);
            }
            out.println(spotX + " " + spotY);

            mX = nextInt();
            mY = nextInt();
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
