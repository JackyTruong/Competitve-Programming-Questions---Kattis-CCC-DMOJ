package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static class Edge implements Comparable<Edge>{
        int src, dest, weight;

        public int compareTo(Edge compareEdge){
            return this.weight-compareEdge.weight;
        }
    }
    public static class Graph{

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

        Edge[] KruskalMST(){
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
                Edge next_edge = new Edge();
                next_edge = edge[i++];
                int x = find(subsets, next_edge.src);
                int y = find(subsets, next_edge.dest);
                if(x != y){
                    result[e++] = next_edge;
                    Union(subsets, x, y);
                }
            }
            return result;
        }
    }

    public static int returnAmount(Edge[] output,ArrayList<Integer> src, ArrayList<Integer> dest, int n){
        int counter = 0;
        for(int o = 0; o < output.length - 1; o++){
            boolean within = false;
            for(int i = 0; i < n - 1; i++){
                if(output[o].src == src.get(i) && output[o].dest == dest.get(i)){
                    within = true;
                    //   System.out.println("this is the stuff" + output[o].src + " " +  src.get(i) + " " +output[o].dest + " " + dest.get(i) );
                    break;

                }
            }
            if(!within){
                counter++;
            }
        }
        return counter;
    }


    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n, m , d;
	    n = sc.nextInt();
	    m = sc.nextInt();
	    d = sc.nextInt();
        ArrayList<Integer> src = new ArrayList<>();
        ArrayList<Integer> dest = new ArrayList<>();
        ArrayList<Integer> weight = new ArrayList<>();
        ArrayList<Graph> graphs = new ArrayList<>();
	    Graph graph =  new Graph(n, m);
	    for(int o = 0 ;o < m; o++){
	        src.add(sc.nextInt()-1);
	        dest.add(sc.nextInt()-1);
            weight.add(sc.nextInt());
            //System.out.println(src.get(o));
            graph.edge[o].src = src.get(o);
            graph.edge[o].dest = dest.get(o);
            graph.edge[o].weight = weight.get(o);
        }
        Edge[] output = graph.KruskalMST();
	    int lowest = returnAmount(output, src, dest, n);

	    if(d != 0){
            for(int i = 0 ; i < n-1 ; i++){
                graphs.add(new Graph(n,m));
                for(int o = 0 ;o<m; o ++){
                    graphs.get(i).edge[o].src = src.get(o);
                    graphs.get(i).edge[o].dest = dest.get(o);
                    graphs.get(i).edge[o].weight = weight.get(o);
                }
                //System.out.println(Math.max(weight.get(i)-d, 0) + " " + i);
                graphs.get(i).edge[i].weight = Math.max(weight.get(i)-d, 0);
            }
            for(int i = 0 ; i < n-1; i++){
                Edge[] outputs = graphs.get(i).KruskalMST();
                int temp = returnAmount(outputs, src, dest, n);
                //System.out.println("this is temp and lowest" + temp +  " " + lowest + " " + i);
                if(temp < lowest){
                    lowest = temp;
                }
            }
        }


	    System.out.println(lowest);
    }
}
