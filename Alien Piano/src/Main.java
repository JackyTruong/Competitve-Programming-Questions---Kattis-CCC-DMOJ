import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K, T;
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        T = nextInt();
        for(int i = 0 ; i < T; i++){
            K = nextInt();
            ArrayList<Integer> pitch = new ArrayList<>();
            for(int o = 0 ; o < K; o++){
                int temp = nextInt();
                if(pitch.size() == 0 || temp != pitch.get(pitch.size()-1)){
                    pitch.add(temp);
                }
            }
            int wrong = 0;
            int up = 0;
            int down = 0;
            for(int o = 1; o < pitch.size(); o++){
                if(pitch.get(o) > pitch.get(o-1)){
                    up++;
                    down = 0;
                }
                else{
                    down++;
                    up = 0;
                }
                if(up > 3 || down > 3){
                    wrong++;
                    up = 0;
                    down = 0;
                }

            }

            out.println("Case #" + (i+1) + ": " + wrong);
        }


        out.close();
    }

    private static String next()throws IOException {
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }


}
