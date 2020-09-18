import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static class Pair{
        ArrayList<ArrayList<String>> groups;
        int timeCost;
        Pair(ArrayList<ArrayList<String>> groups,int timeCost){
            this.groups = groups;
            this.timeCost = timeCost;
        }
    }

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int m, q;
    static String[] name;
    static int[] time;
    static int lowestTime = Integer.MAX_VALUE;


    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        m = nextInt();
        q = nextInt();
        name = new String[q];
        time = new int[q];
        for(int i = 0 ; i < q; i++){
            name[i] = next();
            time[i] = nextInt();
        }

        int[] times = new int[q+1];
        int[] groups = new int[q+1];
        for(int i = 0; i < q + 1; i++){
            times[i] = 1000000;
            groups[i] = -1;
        }
        times[0] = 0;
        groups[0] = 0;
        for(int i = 0 ; i < q + 1; i++){
            int highestTime = 0;
            for(int o = 1; o < m+1 && o + i-1 < q; o++){
                highestTime = Math.max(highestTime, time[o+i-1]);
                if(times[i] + highestTime < times[i+o]){
                    times[i + o] = times[i] + highestTime;
                    groups[i+o] = o;
                }
            }
        }

        out.println("Total Time: " + times[q]);

        int[] groupDiv = new int[q+1];
        int a = q;
        int b = 0;
        while(groups[a] != 0){
            groupDiv[b++] = groups[a];
            a = a - groups[a];
        }
        int c = 0;
        for(int i = b-1;i >= 0;i--){
            for(int o = 0; o < groupDiv[i];o++){
                out.print(name[c++] + " ");
            }
            out.println("");
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}