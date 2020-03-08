package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

class Graph{
    class Edge implements Comparable<Edge>{
        int src, dest, weight;

        public int compareTo(Edge compareEdge){
            return this.weight-compareEdge.weight;
        }
    }
    class subset{
        int parent, rank;
    }
    int V, E;
    Edge[] edge;

    Graph(int v, int e){
        V = v;
        E = e;
        edge = new Edge[E];
        for(int i = 0; i < e; i++){
            edge[i] = new Edge();
        }
    }

    int find(subset[] subsets, int i){
        if(subsets[i].parent != i){
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void Union(subset[] subsets, int x, int y){
        int xroot = find(subsets,x);
        int yroot = find(subsets,y);

        if(subsets[xroot].rank < subsets[yroot].rank){
            subsets[xroot].parent = yroot;
        }
        else if(subsets[xroot].rank > subsets[yroot].rank){
            subsets[yroot].parent = xroot;
        }
        else{
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    long KruskalMST(long saved){
        Edge result[] = new Edge[V];
        int e  = 0;
        int i = 0;
        for(i = 0; i <V;i++){
            result[i] = new Edge();
        }
        Arrays.sort(edge);
        subset[] subsets = new subset[V];
        for(i = 0; i < V; i++){
            subsets[i] = new subset();
        }
        for(int v = 0; v < V;v++){
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while(e < V-1){
            Edge next_edge;
            next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if(x != y){
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
       // System.out.println("edges constructed in MST");
        for(i = 0; i<e; i++){
            //System.out.println(result[i].src + "-->" + result[i].dest + "== weight of" + result[i].weight);
          //  System.out.println("this is the wack" + saved + " " + result[i].weight);
            saved -= result[i].weight;
        }
        return saved;
    }
}
public class Main {
    public static long saved = 0;
    public static boolean repeats(ArrayList<Integer> flights, ArrayList<Integer> flightd,ArrayList<Integer> weightf, int s, int d, int weight, int n){
        for(int i = 0; i < flights.size(); i++){
            if((flights.get(i) == s || flights.get(i) == d) && (flightd.get(i)== s || flightd.get(i) == d)){
                if(weightf.get(i) > weight){
                    saved += weightf.get(i);
                    weightf.set(i, weight);
                }
                else{
                    saved += weight *n;
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)throws Exception{
        int n, m, p, q;
        File file = new File("s5.1-04.in");
        Scanner sc = new Scanner(file);
        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();
        q = sc.nextInt();
        int e = m*q + n*p;
        int v = n*m;
        ArrayList<Integer> flights = new ArrayList<>();
        ArrayList<Integer> flightd = new ArrayList<>();
        ArrayList<Integer> weightf = new ArrayList<>();
        ArrayList<Integer> portals = new ArrayList<>();
        ArrayList<Integer> portald = new ArrayList<>();
        ArrayList<Integer> weightp = new ArrayList<>();
        int edgenum = 0;
       // System.out.println(v + " " + e);
        for(int a = 0; a < p; a++){
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            int p3 = sc.nextInt();
            if(p1 != p2){
                    if(!repeats(flights, flightd,weightf, p1, p2, p3, n)){
                        flights.add(p1);
                        flightd.add(p2);
                        weightf.add(p3);
                    }
                    else{
                        //System.out.println("first" + p1 + " " + p2);
                        e -= n;
                    }

            }
            else{
                saved += p3*n;
            }
           // System.out.println(p1 + " " + p2 + " p" + p3);
        }
        for(int b = 0; b < q; b++){
            int q1 = sc.nextInt();
            int q2 = sc.nextInt();
            int q3 = sc.nextInt();
            if(q1 != q2){
                if(!repeats(portals, portald,weightp, q1, q2, q3, m)){
                    portals.add(q1);
                    portald.add(q2);
                    weightp.add(q3);
                }
                else{
                    //System.out.println("second" + q1 + " " + q2);
                    e -= m;
                }
            }
            else{
                saved += q3*m;
            }
           // System.out.println(portals.city1.get(b) + " " + portals.city2.get(b) + " q" + portals.cost.get(b));
        }
        long weightGraph = 0;
       // System.out.println(v + " " + e);
        Graph graph = new Graph(v, e);
        for(int o = 0; o < n; o++){
            for(int i = 0; i < flights.size(); i++){
                graph.edge[edgenum].src = (flights.get(i))+(m*o) - 1;
                graph.edge[edgenum].dest = (flightd.get(i))+(m*o) - 1;
                graph.edge[edgenum].weight = weightf.get(i);
                //System.out.println("this is the weight of f " + weightf.get(i));
                weightGraph += weightf.get(i);
                edgenum++;
                // System.out.println(edgenum);
            }
        }
        for(int o = 1; o < m+1; o++){
        for(int i = 0; i < portals.size(); i++){
                graph.edge[edgenum].src = ((((portals.get(i)-1)*m)+o)-1);
                graph.edge[edgenum].dest = ((((portald.get(i)-1)*m)+o)-1);
                graph.edge[edgenum].weight = weightp.get(i);
                edgenum++;
                weightGraph += weightp.get(i);
                // System.out.println(edgenum);
            }

        }
       // System.out.println(edgenum);
        //System.out.println(flights);
        //System.out.println(flightd);
        //System.out.println(weightf);
        //System.out.println(portals);
        //System.out.println(portald);
        //System.out.println("this is weight of graph" + weightGraph);
        //System.out.println(saved);
        saved += graph.KruskalMST(weightGraph);
        System.out.println(saved);
    }
}
