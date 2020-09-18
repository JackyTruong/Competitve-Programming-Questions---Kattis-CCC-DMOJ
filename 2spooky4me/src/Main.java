import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int spooky = nextInt(), houses = nextInt(), fearFactor = nextInt();
        int[] fearLevel = new int[houses+1];
        for(int i = 0 ; i < spooky; i++){
            int start = nextInt();
            int end = nextInt()+1;
            int fear = nextInt();
            fearLevel[start] += fear;
            fearLevel[end] -= fear;
        }
        int[] prefix = new int[houses+1];
        int count = 0;
        for(int i = 1; i <= houses; i++){
            prefix[i] = prefix[i-1] + fearLevel[i];
            if(prefix[i] < fearFactor){
                count++;
                //System.out.println(i);
            }
        }
        out.println(count);

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
