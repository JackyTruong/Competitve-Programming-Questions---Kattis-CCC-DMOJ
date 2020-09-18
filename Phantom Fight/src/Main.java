import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int highestG, mL;
    static Ghost[] cost;
    static int ghosts;

    static class Ghost implements Comparable<Ghost>{
        int cost, regain, diff;
        public Ghost(int cost, int regain, int diff){
            this.cost = cost;
            this.regain = regain;
            this.diff = diff;
        }

        public int compareTo(Ghost other){
            return other.diff-this.diff;
        }

    }

    private static void findGhost(int spot, int magic, int count){
        if((ghosts-spot) + count > highestG){
            if(spot < ghosts && cost[spot].cost <= magic){
                findGhost(spot+1, magic + cost[spot].diff, count+1);
                findGhost(spot+1, magic, count);
            }
            else if(spot < ghosts){
                findGhost(spot+1, magic, count);
            }
            if(count > highestG){
                highestG = count;
                mL = magic;
            }
            else if(count == highestG && magic > mL){
                mL = magic;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        ghosts = nextInt();int magic = nextInt();
        highestG = 0;
        mL = magic;
        cost = new Ghost[ghosts];
        for(int i = 0 ; i < ghosts; i++){
            int baseC = nextInt();
            int backM = nextInt();
            cost[i] = new Ghost(baseC, backM, backM-baseC);
        }
        findGhost(0, magic, 0);
        out.println(highestG + " " + mL);





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
