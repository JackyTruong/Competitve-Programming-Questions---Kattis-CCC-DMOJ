
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int maxTime = nextInt();
        int numChores = nextInt();
        int[] times = new int[numChores];
        for(int i = 0 ; i < numChores; i++){
            times[i] = nextInt();
        }
        Arrays.sort(times);
        int numDone = 0;
        for(int i = 0 ; i < numChores; i++){
            if(maxTime-times[i] >= 0){
                maxTime -= times[i];
                numDone++;
            }
            else{
                break;
            }
        }
        out.println(numDone);


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
