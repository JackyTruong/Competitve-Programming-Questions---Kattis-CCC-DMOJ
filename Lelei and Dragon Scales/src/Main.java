import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int W,H,N;
    static int[][] map, preSum;
    static int highest;

    private static void PreSum(){
        for(int o = 0 ; o < H; o++){
            int base = 0;
            for(int i = 0 ; i < W; i++){
                base += map[o][i];
                preSum[o][i] = base;
            }
        }
    }

    private static void recs(int h, int w){
        for(int i = 0 ; i <= H-h; i++){
            for(int o = 0 ; o <= W-w;o++){
                int total = 0;
                for(int a = 0 ; a < h; a++){
                    total += preSum[a+i][o+w-1];
                }
                if(o > 0){
                    for(int a = 0; a < h; a++){
                        total -= preSum[a+i][o-1];

                    }
                }
                if(total > highest){
                    highest = total;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        W = nextInt(); H = nextInt(); N = nextInt();
        highest = 0;
        map = new int[H][W];
        preSum = new int[H][W];
        for(int i = 0 ;i < H; i++){
            for(int o = 0; o < W; o++){
                map[i][o] = nextInt();
            }
        }
        PreSum();
        /*
        for(int i = 0 ; i < H ;i++){
            for(int o = 0 ; o < W; o++){
                System.out.print(preSum[i][o] + " ");
            }
            System.out.println();
        }

         */
        recs(N, 1);
        recs(1, N);
        for(int i = 2; i < N; i++){
            recs(i, N-i);
            recs(N-i, i);
        }
        if(N == 1){
            for(int i = 0; i < H; i++){
                for(int o = 0 ; o < W; o++){
                    if(map[i][o] > highest){
                        highest = map[i][o];
                    }
                }
            }
        }
        out.println(highest);


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st=  new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
