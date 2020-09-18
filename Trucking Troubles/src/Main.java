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
        int cities = nextInt(), roads = nextInt(), destinations = nextInt();
        Integer[][] weights = new Integer[cities+1][cities+1];
        for(int i = 0 ; i < cities+1; i++){
            Arrays.fill(weights[i],0);
        }
        Integer[] dest = new Integer[destinations];
        for(int i = 0 ; i < roads;i++){
            int a = nextInt(), b = nextInt(), c = nextInt();
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }
            if(c > weights[a][b]){
                weights[a][b] = c;
                weights[b][a] = c;
            }
        }
        for(int i = 0; i < destinations; i++){
            dest[i] = nextInt();
        }
        Integer[] v = new Integer[cities+1];
        boolean[] visited = new boolean[cities+1];
        for (int k = 0 ; k < cities + 1 ; k++)
        {
            v [k] = 0;
            visited [k] = false;
        }
        v[1] = 100000;
        int max = 1;
        while(max != -1){
            int i = max;
            visited[max] = true;
            int tempMax = 0;
            max = -1;
            for(int a = 1; a < cities+1; a++){
                if(v[a] < Math.min(v[i], weights[i][a])){
                    v[a] = Math.min(v[i],weights[i][a]);
                }
                if(v[a] >= tempMax && !visited[a]){
                    tempMax = v[a];
                    max = a;
                }
            }
        }

        int least = 100000;
        for(int i = 0 ; i < destinations; i++){
            if(v[dest[i]] < least){
                least = v[dest[i]];
            }
        }
        out.println(least);

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
