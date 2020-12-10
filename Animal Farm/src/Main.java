import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n, edges;
    static int[][] g;
    static animalC[][] pens;


    static class animalC{
        int animal, cost;
        public animalC(int animal, int cost){
            this.animal = animal;
            this.cost = cost;
        }
    }

    private static int prims(int n){
        int unseen = 999999999;
        int[] v = new int[n+1];
        for(int i = 1; i <= n ;i++){
            v[i] = -unseen;
        }
        v[0] = -(unseen+1);
        int min = 1;
        int o;
        do{
            o = min;
            v[o] = -v[o];
            min = 0;
            if(v[o] == unseen){
                v[o] = 0;
            }
            for(int i = 1 ; i <= n ; i++){
                if(v[i] < 0){
                    if(g[o-1][i-1] != 999999999 && v[i] < -(g[o-1][i-1])){

                        v[i] = -(g[o-1][i-1]);
                        //System.out.println("here " + v[i]);
                    }
                    if(v[i] > v[min]){
                        min = i;
                    }
                }
            }
        }while(min != 0);
        int output = 0;
        for(int i = 1; i <= n ;i++){
            //System.out.println(output);
            output += v[i];
        }
        return output;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        int[] corner = new int[1001];
        int[] cost = new int[1001];
        g = new int[n+1][n+1];
        for(int i = 0 ; i <= n ; i++){
            for(int o = 0; o <= n ; o++){
                g[i][o] = 999999999;
            }
        }
        for(int i = 0 ;i <= n; i++){
            g[i][i] = 0;
        }
        pens = new animalC[1001][1001];
        for(int i = 0 ; i <= 1000; i++){
            for(int o = 0 ; o <= 1000; o++){
                pens[i][o] = new animalC(-1, 0);
            }
        }
        for(int i = 0 ; i< n; i++){
            edges = nextInt();
            for(int o = 0 ; o < edges; o++){
                corner[o] = nextInt();
            }
            for(int o = 0 ; o < edges; o++){
                cost[o] = nextInt();
            }
            for(int o = 0 ; o < edges; o++){
                int temp = (o+1)%edges;
                if(pens[corner[o]][corner[temp]].cost > 0){
                    if(g[i][pens[corner[o]][corner[temp]].animal] > cost[o]){
                        g[i][pens[corner[o]][corner[temp]].animal] = cost[o];
                        g[pens[corner[o]][corner[temp]].animal][i] = cost[o];
                    }
                    pens[corner[o]][corner[temp]].animal = -1;
                    pens[corner[temp]][corner[o]].animal = -1;
                }
                else{
                    pens[corner[o]][corner[temp]].cost = cost[o];
                    pens[corner[o]][corner[temp]].animal = i;
                    pens[corner[temp]][corner[o]].cost = cost[o];
                    pens[corner[temp]][corner[o]].animal = i;
                }
            }
        }

        for(int i = 0 ; i <= 1000; i++){
            for(int o = 0; o <= 1000; o++){
                if(pens[i][o].animal >= 0){
                    if(g[pens[i][o].animal][n] > pens[i][o].cost){
                        g[pens[i][o].animal][n] = pens[i][o].cost;
                        g[n][pens[i][o].animal] = pens[i][o].cost;
                    }
                }
            }
        }
        int inside = prims(n);
        int outside = prims(n+1);
        out.println(Math.min(inside, outside));

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
