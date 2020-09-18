
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int r, l;

    private static String but(String a, String b){
        String output = "";
        for(int i = 0 ; i < a.length(); i++){
            if(a.charAt(i) == b.charAt(i)){
                output += "0";
            }
            else{
                output += "1";
            }
        }
        return output;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] top = new String[256];
        String[] bot = new String[256];
        String newRow;
        r = nextInt();l = nextInt();
        int a;
        String[] row = new String[r];
        for(int i = 0; i < r; i++){
            row[i] = "";
            for(int o = 0 ; o < l; o++){
                row[i] += next();
            }
        }
        top[0] = row[0];
        int topSize = 1;
        int botSize = 1;
        for(int i = 0 ; i < r; i++){
            bot[0] = row[i];
            botSize = 1;
            for(int o = 0; o < topSize; o++){
                newRow = but(top[o], bot[0]);
                a = 0;
                while(a < botSize && !bot[a].equals(newRow)){
                    a++;
                }
                if(a >= botSize){
                    bot[botSize] = newRow;
                    botSize++;
                }
            }
            for(int o = 0 ;o  < botSize; o++){
                top[o] = bot[o];
            }
            topSize = botSize;
        }
        out.println(botSize);

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
