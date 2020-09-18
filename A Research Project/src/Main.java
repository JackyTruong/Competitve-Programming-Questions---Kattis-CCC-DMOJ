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
        for(int i = 0 ; i < n; i++){
            int pics = nextInt();
            int highest = 0;
            int lowest = 101;
            for(int o = 0 ; o < pics; o++){
                int temp = nextInt();
                if(temp < lowest){
                    lowest = temp;
                }
                if(temp > highest){
                    highest = temp;
                }
            }
            out.println(lowest + " " + highest);
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
