import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[] count, pInC;
    static ArrayList<Integer>[] connections;

    private static int findConn(int n){
        if(count[n] == 0){
            count[n] += pInC[n]-1;
            ArrayList<Integer> beenTo = new ArrayList<>();
            for(int i = 0 ; i < connections[n].size(); i++){
                if(!beenTo.contains(connections[n].get(i))){
                    count[n]++;
                    beenTo.add(connections[n].get(i));
                }
            }
        }
        return count[n];
    }

    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        pInC = new int[n];
        connections = new ArrayList[n];
        Pair[] pairs = new Pair[n-1];
        for(int i = 0 ; i < n; i++){
            connections[i] = new ArrayList<>();
            pInC[i] = nextInt();
        }

        for(int i = 0 ; i < n-1; i++){
            int x = nextInt()-1;
            int y = nextInt()-1;
            connections[x].add(y);
            pairs[i] = new Pair(x,y);
        }
        count = new int[n];
        for(int i = 0 ; i < n; i++){
            if(count[i] == 0){
                findConn(i);
            }
        }
        int total = 0;
        for(int i = 0 ; i < n; i++){
            total += count[i]*pInC[i];
        }
        for(int i = 0 ; i < n-1; i++){
            ArrayList<Integer> temp = (ArrayList<Integer>)connections[pairs[i].y].clone();
            connections[pairs[i].y].add(pairs[i].x);
            count = new int[n];
            for(int o = 0 ; o < n; o++) {
                if (count[o] == 0) {
                    findConn(o);
                }
            }
            int tempT = 0;
            for(int o = 0 ; o < n; o++){
                //System.out.println(count[i] * pInC[i] + " " + count[i] + " " + pInC[i]);
                tempT += count[i]*pInC[i];
            }
            System.out.println(tempT + " " + total);
            total = Math.max(total, tempT);
            connections[pairs[i].y] = (ArrayList<Integer>)temp.clone();
        }
        out.println(total);



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

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }

    private static double nextDouble()throws IOException{
        return Double.parseDouble(next());
    }

}
