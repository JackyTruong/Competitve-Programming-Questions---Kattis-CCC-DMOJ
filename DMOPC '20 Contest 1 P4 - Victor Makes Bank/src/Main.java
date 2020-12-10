import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static long[][] base, forward;
    static long N, K, T, C;
    static long[] cArr;

    private static void multiplyBase(){
        int len = base.length;
        long[][] temp = new long[len][len];
        //ROW
        for(int o = 0 ; o < len; o++){
            //COL
            for(int i = 0 ; i < len; i++){
                //SLOT
                long num = 0;
                for(int a = 0; a < len ; a++){
                    //System.out.println("this forward " + forward[o][a] + " " + base[i][a]);
                    //System.out.println("pairs " + o + " " + a + " " + i + " " + a);
                    num += (forward[o][a] * base[a][i])%1000000007;
                }
                temp[o][i] = num;
            }
        }
        forward = temp.clone();
        /*
        for(int i = 0 ; i < len; i++){
            for(int o = 0 ;o  < len; o++){
                out.print(temp[i][o] + " ");
            }
            out.println();
        }
        out.println();

         */

    }

    private static void multiplyC(){
        int len = base.length;
        long[] temp = new long[len];
        for(int i = 0 ; i < len; i++){
            long num = 0;
            for(int o = 0 ; o < len; o++){
                num += forward[i][o] * cArr[o];
            }
            temp[i] = num;
        }
        long count = 0;
        for(int i = 0 ;i < len-1; i++){
            count += temp[i] % 1000000007;
        }
        count += (temp[len-1]*2)%1000000007;
        out.println(count);
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        N = nextLong(); K = nextLong(); T = nextLong(); C = nextLong();
        base = new long[(int)T+1][(int)T+1];
        cArr = new long[(int)T+1];
        cArr[(int)T] = C;
        for(int i = 0 ; i < T; i++){
            base[i+1][i] = 1;
        }
        base[0][(int)T] = K;
        base[(int)T][(int)T] = 1;
        /*
        for(int i = 0 ; i < T+1; i++){
            for(int o = 0 ;o  < T+1; o++){
                out.print(base[i][o] + " ");
            }
            out.println();
        }
        out.println();

         */
        forward = base.clone();
        /*
        for(int i = 0 ; i < T+1; i++){
            for(int o = 0 ;o  < T+1; o++){
                out.print(forward[i][o] + " ");
            }
            out.println();
        }
        out.println();

         */
        for(int i = 0 ; i < N-2; i++){
            multiplyBase();
        }
        multiplyC();
        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st= new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }

}
