import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int t,n,k,w, score;
    static int[] pins, sumPins;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        t = nextInt();
        for(int z = 0 ;z < t; z++){
            n = nextInt();k = nextInt();w = nextInt();
            pins = new int[n];
            score = 0;
            for(int i = 0 ; i < n; i++){
                pins[i] = nextInt();
            }
            sumPins = new int[n];
            int sum = 0;
            for(int i = 0 ; i < w; i++){
                sum += pins[i];
            }
            sumPins[0] = sum;
            for(int i = 1; i < n - w+1; i++){
                sum = sum - pins[i-1] + pins[i+w-1];
                sumPins[i] = sum;
            }
            for(int i = n-w+1; i < n; i++){
                sum = sum-pins[i-1];
                sumPins[i] = sum;
            }
            int[][] combin = new int[k+1][n];
            for(int i = 1; i < n; i++){
                combin[0][i] = 0;
            }
            for(int i = 1; i <= k; i++){
                for(int o = 1 ; o < n; o++){
                    combin[i][o] = -1;
                }
            }
            for(int i = 1; i <= k ; i++){
                for(int o = n-1;o >= 0; o--){
                    if(o >= n-w){
                        combin[i][o] = sumPins[o];
                    }
                    else{
                        combin[i][o] = Math.max(combin[i-1][o+w] + sumPins[o],combin[i][o+1]);
                    }
                }
            }
            out.println(combin[k][0]);

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
