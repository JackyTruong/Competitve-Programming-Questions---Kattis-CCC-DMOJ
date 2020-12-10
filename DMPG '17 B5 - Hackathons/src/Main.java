import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static class Project implements Comparable<Project>{
        int time, weight;
        public Project(int time, int weight){
            this.time = time;
            this.weight = weight;
        }
        public int compareTo(Project other){
            return other.weight-this.weight;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        Project[] arr = new Project[n];
        int[] temp = new int[1000001];
        for(int i = 0 ; i < n; i++){
            arr[i] = new Project(nextInt(), nextInt());
        }
        Arrays.sort(arr);
        int smallestSpot = 1000001;
        for(int i = 0 ; i < n && temp[1] == 0; i++){
            int timeS = arr[i].time;
            int weightS = arr[i].weight;
            for(int o = timeS; o < smallestSpot; o++){
                temp[o] = weightS;
            }
            if(timeS < smallestSpot){
                smallestSpot = timeS;
            }
        }
        int q = nextInt();
        for(int i = 0 ; i < q; i++){
            int time = nextInt();
            out.println(temp[time]);
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
