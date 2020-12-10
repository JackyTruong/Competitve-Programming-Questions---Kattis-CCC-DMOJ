import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        Integer[] weights = new Integer[n];
        for(int i = 0; i < n; i++){
            weights[i] = nextInt();
        }
        Arrays.sort(weights);
        out.println(findLowestOfFront(weights));
        out.close();
    }

    private static int closestNumber(int i, int o){
        int iabs = Math.abs(1000-i);
        int oabs = Math.abs(1000-o);
        if(iabs < oabs){
            return i;
        }
        else{
            return o;
        }
    }


    //BRO JUST ITERATE THROUGH ALL THE COMBINATIONS ITS JUST LESS WORK FINISH THIS WHEN UR BACK

    private static int findLowestOfFront(Integer[] weights){
        int closest = 0;
        int temp = 0;
        for(int i = 0; i < weights.length-1; i++){
            if(temp + weights[i] < 1000){
                temp += weights[i];
            }
            else{
                closest = closestNumber(temp, temp+weights[i]);
                temp = 0;
            }
        }
        return closest;
    }



   static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

   static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }
}
