import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), k = nextInt(), d = nextInt();
        int[] jacks = new int[k];
        Arrays.fill(jacks, 1);
        int upTo = 0;
        int crushed = 0;
        for(int i = 0 ; i < n; i++){
            String temp = next();
            if(temp.equals("T")){
                upTo++;
            }
            else if(temp.equals("B")){
                int breaks = nextInt();
                for(int o = crushed ;o < upTo; o++){
                    jacks[o] *= breaks;
                    //System.out.println(jacks[o]);
                    if(jacks[o] > d){
                        crushed++;
                    }
                }
            }
        }
        for(int i = 0; i < crushed; i++){
            out.println("dust");
        }
        for(int i = crushed ; i < k; i++){
            out.println(jacks[i]);
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
