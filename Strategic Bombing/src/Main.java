import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        ArrayList<String> roads = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<String> removeable = new ArrayList<>();
        String temp = next();
        while (!temp.equals("**")) {
            roads.add(temp);
            temp = next();
        }
        for(int i = 0 ; i < 26;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < roads.size();i++){
            addEdge(adj, (int)roads.get(i).charAt(0)-65, (int)roads.get(i).charAt(1)-65);
        }

        for(int i = 0; i < roads.size();i++){
            int temp1 = roads.get(i).charAt(0)-65;
            int temp2 = roads.get(i).charAt(1)-65;
         // out.println(roads.get(i) + " " + temp1 + " " + temp2);
        }
        String tempRoad;
        int tempDist;
        for(int i = 0; i < roads.size();i++){
            tempRoad = roads.get(i);
            removeEdge(adj, (int)tempRoad.charAt(0)-65, (int)tempRoad.charAt(1)-65);
            tempDist = shortestDistance(adj, 0, 1);
            if(tempDist == -1){
                removeable.add(tempRoad);
            }
            addEdge(adj, (int)tempRoad.charAt(0)-65, (int)tempRoad.charAt(1)-65);
        }

        for(int i = 0 ; i < removeable.size();i++){
            out.println(removeable.get(i));
        }
        out.println("There are " + removeable.size() + " disconnecting roads.");

        //TODO now you gotta remove every single one test if there is a way if not then add to an arraylist keeping them all together then outputting

        out.close();
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int src, int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }

    private static void removeEdge(ArrayList<ArrayList<Integer>> adj, int src, int dest){
        adj.get(src).remove(new Integer(dest));
        adj.get(dest).remove(new Integer(src));
    }

    private static int shortestDistance(ArrayList<ArrayList<Integer>> adj, int src, int dest){
        int[] dist = new int[26];
        if(!BFS(adj, src, dest, dist)){
            return -1;
        }
        //out.println(dist[dest]);
        return dist[dest];
    }

    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src, int dest, int[] dist){
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[26];
        for(int i = 0 ; i < 26;i++){
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);
        while(!queue.isEmpty()){
            int u = queue.remove();
            for(int i = 0 ; i < adj.get(u).size();i++){
                if(!visited[adj.get(u).get(i)]){
                    visited[adj.get(u).get(i)] = true;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    queue.add(adj.get(u).get(i));
                    if(adj.get(u).get(i) == dest){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st =  new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}
