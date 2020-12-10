import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static Vector<Cost>[] graph;
    static int hullK, islandsN, seaRM;
    static int start, end, shortest, second;

    static class Cost{
        int place,  time, dmg;
        Cost(int place, int time, int dmg){
            this.place = place;
            this.time = time;
            this.dmg = dmg;
        }
    }

    static void addEdge(int start, int end, int time, int dmg){
        graph[start].add(new Cost(end, time, dmg));
        graph[end].add(new Cost(start, time, dmg));
    }

    private static void shortestPath(int start, int end){
        int[] dist = new int[islandsN];
        int[] dmgedH = new int[islandsN];
        boolean[] inQ = new boolean[islandsN];
        for(int i = 0 ; i < islandsN; i++){
            dist[i] = Integer.MAX_VALUE;
            dmgedH[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        dmgedH[start] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        inQ[start] = true;
        while(!q.isEmpty()){
            int fV = q.remove();
            inQ[fV] = false;
            for(int i = 0 ; i < graph[fV].size(); i++){
                int v = graph[fV].get(i).place;
                int time = graph[fV].get(i).time;
                int hull = graph[fV].get(i).dmg;
                //out.println("here " + dist[fV] + " " + (dist[fV] + time) + " " + (dmgedH[fV] + hull));


                if(dist[v] > dist[fV] + time && dmgedH[fV] + hull < hullK){

                    dist[v] = dist[fV] + time;
                    dmgedH[v] = dmgedH[fV] + hull;

                    if(!inQ[v]){
                        q.add(v);
                        inQ[v] = true;
                    }
                }
            }
        }
        shortest = dist[end];
    }

    private static void shortestPathv2(int start, int end){
        int[] dist = new int[islandsN];
        int[] dmgedH = new int[islandsN];
        boolean[] inQ = new boolean[islandsN];
        for(int i = 0 ; i < islandsN; i++){
            dist[i] = Integer.MAX_VALUE;
            dmgedH[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        dmgedH[start] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        inQ[start] = true;
        while(!q.isEmpty()){
            int fV = q.remove();
            inQ[fV] = false;
            for(int i = 0 ; i < graph[fV].size(); i++){
                int v = graph[fV].get(i).place;
                int time = graph[fV].get(i).time;
                int hull = graph[fV].get(i).dmg;
                //out.println("here " + dist[fV] + " " + (dist[fV] + time) + " " + (dmgedH[fV] + hull));


                if((dist[v] > dist[fV] + time || dmgedH[fV] + hull <= dmgedH[v])&& dmgedH[fV] + hull < hullK){

                    dist[v] = dist[fV] + time;
                    dmgedH[v] = dmgedH[fV] + hull;

                    if(!inQ[v]){
                        q.add(v);
                        inQ[v] = true;
                    }
                }
            }
        }
        second = dist[end];
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        hullK = nextInt(); islandsN = nextInt(); seaRM = nextInt();
        graph = new Vector[islandsN];
        for(int i = 0 ; i < islandsN; i++){
            graph[i] = new Vector<>();
        }
        for(int i = 0 ; i < seaRM ;i++){
            int first = nextInt()-1, second = nextInt()-1, time = nextInt(), cost = nextInt();
            addEdge(first, second, time, cost);
        }
        start = nextInt()-1;
        end = nextInt()-1;
        shortestPath(start, end);
        if(shortest == Integer.MAX_VALUE){
            shortestPathv2(start, end);
            int temp = Math.min(shortest, second);
            if(temp != Integer.MAX_VALUE){
                out.println(temp);
            }
            else{
                out.println(-1);
            }

        }
        else{
            out.println(shortest);
        }



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
