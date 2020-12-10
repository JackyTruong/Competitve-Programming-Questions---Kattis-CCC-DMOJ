package com.company;

import java.util.Arrays;

class Graph{
    class Edge implements Comparable<Edge>{
        int src, dest, weight;
        public int compareTo(Edge compareEdge){
            return compareEdge.weight-this.weight;
        }
    }
    int V, E;
    Edge[] edge;
    class subset {
        int parent, rank;
    }

    Graph(int v, int e){
        V = v;
        E = e;
        edge = new Edge[E];
        for(int i = 0 ; i < e; i++){
            edge[i] = new Edge();
        }
    }

    int find(subset[] Subsets, int i){
        if(Subsets[i].parent != i){
            Subsets[i].parent = find(Subsets, Subsets[i].parent);
        }
        return Subsets[i].parent;
    }

    void Union(subset[] Subsets, int x, int y){
        int xroot = find(Subsets, x);
        int yroot = find(Subsets,y);
        if(Subsets[xroot].rank < Subsets[yroot].rank){
            Subsets[xroot].parent = yroot;
        }
        else if(Subsets[yroot].rank < Subsets[xroot].rank){
            Subsets[yroot].parent = xroot;
        }
        else{
            Subsets[xroot].parent = yroot;
            Subsets[yroot].rank++;
        }
    }

    void KruskalsAlgo(){
        Edge[] result = new Edge[V];
        for(int i = 0 ; i < V;i++){
            result[i] = new Edge();
        }
        Arrays.sort(edge);
        subset Subsets[] = new subset[V];
        for(int i = 0 ; i < V;i++){
            Subsets[i] = new subset();
            Subsets[i].parent = i;
            Subsets[i].rank = 0;
        }
        int i = 0;
        int e = 0;
        while(e < V-1){
            Edge next_Edge = edge[i++];
            int x = find(Subsets, next_Edge.src);
            int y = find(Subsets, next_Edge.dest);
            if(x != y){
                result[e++] = next_Edge;
                Union(Subsets, x, y);
            }
        }
        System.out.println("these are the edges");
        for(int o = 0; o < e; o++){
            System.out.println(result[o].src + " --> " + result[o].dest + " = " + result[o].weight);
        }

    }

}

public class Main {

    public static void main(String[] args) {
        int V = 5;
        int E = 7;
        Graph graph = new Graph(V,E);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 20;
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 50;
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 70;
        graph.edge[3].src = 0;
        graph.edge[3].dest = 4;
        graph.edge[3].weight = 90;
        graph.edge[4].src = 1;
        graph.edge[4].dest = 2;
        graph.edge[4].weight = 30;
        graph.edge[5].src = 2;
        graph.edge[5].dest = 3;
        graph.edge[5].weight = 40;
        graph.edge[6].src = 3;
        graph.edge[6].dest = 4;
        graph.edge[6].weight = 60;

        graph.KruskalsAlgo();
    }
}
