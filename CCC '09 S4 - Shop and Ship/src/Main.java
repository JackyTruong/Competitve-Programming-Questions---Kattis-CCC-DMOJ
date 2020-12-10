import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static Vector<Path>[] graph;
    static int[] dist;
    static Path[] buyCost;
    static int n, t, k;

    static class Path{
        int to, cost;
        public Path(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    private static void addEdge(int start, int end, int weight){
        graph[start].add(new Path(end, weight));
        graph[end].add(new Path(start,weight));
    }

    private static void shortestPath(int start){
        dist = new int[n];
        for(int i = 0 ; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        boolean[] inQ = new boolean[n];
        inQ[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int fV = q.remove();
            inQ[fV] = false;
            for(int i = 0 ; i < graph[fV].size(); i++){
                int v = graph[fV].get(i).to;
                int cost = graph[fV].get(i).cost;
                if(dist[v] > cost + dist[fV]){
                    dist[v] = cost + dist[fV];
                    if(!inQ[v]){
                        q.add(v);
                        inQ[v] = true;
                    }
                }
            }
        }
    }


    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        graph = new Vector[n];
        for(int i  = 0 ; i< n; i++){
            graph[i] = new Vector<>();
        }
        t = nextInt();
        for(int i = 0 ; i < t; i++){
            addEdge(nextInt()-1, nextInt()-1, nextInt());
        }
        k = nextInt();
        buyCost = new Path[k];
        for(int i = 0 ; i < k; i++){
            buyCost[i] = new Path(nextInt()-1, nextInt());
        }
        int dest = nextInt()-1;
        shortestPath(dest);
        int lowCost = Integer.MAX_VALUE;
        for(int i = 0 ; i < k; i++){
            if(buyCost[i].cost != -1 && buyCost[i].cost + dist[buyCost[i].to] < lowCost){
                lowCost = buyCost[i].cost + dist[buyCost[i].to];
            }
        }
        out.println(lowCost);



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
