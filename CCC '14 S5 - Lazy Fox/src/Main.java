import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static class Path implements Comparable<Path> {
        int x, y;
        double weight;

        public Path(int x, int y, double weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        public int compareTo(Path b){
            if (this.weight < b.weight) return -1;
            if (this.weight > b.weight) return 1;
            return 0;
        }

    }


    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int[][] inputs = new int[n+1][2];
        inputs[0][0] = 0;
        inputs[0][1] = 0;
        ArrayList<Path> dist = new ArrayList<>();
        for(int i = 1 ; i < n+1; i++){
            inputs[i][0] = nextInt();
            inputs[i][1] = nextInt();
        }
        //0,0 == 10000, 10000
        for(int i = 0 ; i < n+1; i++){
            for(int o = i+1; o < n+1; o++){
                int dx = inputs[i][0] - inputs[o][0];
                int dy = inputs[i][1] - inputs[o][1];
                dist.add(new Path(i, o, dx*dx + dy*dy));
            }
        }
        Collections.sort(dist);
        int[] best = new int[n+1];
        double[] pDist = new double[n+1];
        int[] pBest = new int[n+1];

        for(int i = 0 ; i < dist.size(); i++){
            double distance = dist.get(i).weight;
            int x = dist.get(i).x;
            int y = dist.get(i).y;
            if(distance != pDist[x]){
                pDist[x] = distance;
                pBest[x] = best[x];
            }
            if(distance != pDist[y]){
                pDist[y] = distance;
                pBest[y] = best[y];
            }
            if(x == 0){
                best[x] = Math.max(best[x], pBest[y]);
            }
            else{
                best[x] = Math.max(best[x], pBest[y]+1);
                best[y] = Math.max(best[y], pBest[x] + 1);
            }
        }
        out.println(best[0] + 1);





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
