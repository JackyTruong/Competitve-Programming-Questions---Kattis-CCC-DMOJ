import java.io.*;
import java.util.*;

class Pair{
    int T, M;

    Pair(int T, int M){
        this.T = T;
        this.M = M;
    }


}
 class sortByT implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        return a.T - b.T;
    }
}
class sortByM implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        return a.M - b.M;
    }
}


public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        ArrayList<Pair> run = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            int tempT = nextInt();
            int tempM = nextInt();
            run.add(new Pair(tempT, tempM));
        }
        Collections.sort(run, new sortByT());

        double fastest = 0;
        for(int i = 0 ; i < run.size()-1;){
                double first = run.get(i).M - run.get(i+1).M;
                double second = run.get(i).T - run.get(i+1).T;
                double speed = Math.abs(first/second);
                //System.out.println("these are speds" + speed + " " + first + " " + second);
                if(speed > fastest){
                    fastest = speed;
                }
            run.remove(0);
        }
        out.println(fastest);
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
