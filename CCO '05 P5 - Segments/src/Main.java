import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n, spotC;
    static int[][] needTo;

    private static int findDist(int spot, int i){
        int dist = 0;
        if(i+1 < n && (Math.abs(needTo[i][0]-spot) == Math.abs(needTo[i][1]-spot))){
            int min = Math.abs(needTo[i][0]-spot);
            dist+=min;
            dist+=needTo[i][1]-needTo[i][0];
            dist++;
            //System.out.println((i+1) + " this" + n );
            //System.out.println(needTo[i+1][0] + " " + needTo[i+1][1]);
            int tempF = findDist(needTo[i][0], i+1);
            int tempS = findDist(needTo[i][1], i+1);
            //System.out.println("these are temps " + tempF + ' ' + tempS);
            if(tempF < tempS){
                spotC = needTo[i][0];
            }
            else{
                spotC = needTo[i][1];
            }
        }
        else if(needTo[i][0] < spot && needTo[i][1] > spot){
            //TODO BETWEEN THE LEFT AND THE RIGHT GO TO CLOSER FIRST THEN THE FARTHER
            int min;
            if(Math.abs(needTo[i][0]-spot) < Math.abs(needTo[i][1]-spot)){
                min = Math.abs(needTo[i][0]-spot);
                spotC = needTo[i][1];
            }
            else{
                min = Math.abs(needTo[i][1]-spotC);
                spotC = needTo[i][0];
            }
            dist += min;
            dist += needTo[i][1]-needTo[i][0];
            dist++;
        }
        else if(needTo[i][0] < spot && needTo[i][1] <= spot){
            //TODO BOTH ON LEFT OF SPOT SO JUST GO TO FARTHEST
            dist += spot-needTo[i][0];
            spotC = needTo[i][0];
            dist++;
        }
        else if(needTo[i][0] >= spot && needTo[i][1] > spot){
            //TODO SAME IDEA AS PREV BOTH ON RIGHT SO GO TO FARTHEST
            dist += needTo[i][1]-spot;
            spotC = needTo[i][1];
            dist++;
        }

        //System.out.println("this spot " + (spotC+1));
        return dist;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        needTo = new int[n][2];
        for(int i = 0; i < n; i++){
            needTo[i][0] = nextInt()-1;
            needTo[i][1] = nextInt()-1;
        }
        spotC = 0;
        int dist = 0;
        for(int i = 0; i < n-1; i++){
            dist += findDist(spotC, i);
           //System.out.println(dist + " " + spotC);
        }
        if(needTo[n-1][0] < spotC){
            dist += spotC-needTo[n-1][0];
            dist += (n-1) - needTo[n-1][0];
        }
        else{
            dist += (n-1)-spotC;
        }
        out.println(dist);


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
