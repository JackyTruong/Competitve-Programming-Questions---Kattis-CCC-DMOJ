import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    static class Pair{
        int src, dest;
        public Pair(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int[] ways = new int[n+1];
        ways[1] = 1;
        ArrayList<Pair> paths = new ArrayList<>();
        int first = nextInt(), second = nextInt();
        while(first != 0 && second != 0){
            paths.add(new Pair(first, second));
            first = nextInt();
            second = nextInt();
        }
        for(int i = 1; i < n+1; i++){
            for(int o = 0 ; o < paths.size(); o++){
                if(paths.get(o).dest == i){
                    ways[i] += ways[paths.get(o).src];
                }
            }
        }
        out.println(ways[n]);

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
