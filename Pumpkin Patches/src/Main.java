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
        int highestX=-10000001, lowestX=1000001, highestY=-1000001, lowestY=1000001;
        for(int i = 0; i < n; i++){
            int x = nextInt(), y = nextInt();
            if(x > highestX){
                highestX = x;
            }
            if(x < lowestX){
                lowestX = x;
            }
            if(y > highestY){
                highestY = y;
            }
            if(y < lowestY){
                lowestY = y;
            }
        }
        out.println((Math.abs(highestX-lowestX) * 2) + (Math.abs(highestY-lowestY) *2));


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
