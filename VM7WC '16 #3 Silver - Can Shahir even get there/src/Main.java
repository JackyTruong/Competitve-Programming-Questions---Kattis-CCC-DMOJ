import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] beenTo;
    static boolean madeIt;

    private static void travel(int end, int spot){
        if(!madeIt && !beenTo[spot]){
            if(spot == end){
                madeIt = true;
            }
            beenTo[spot] = true;
            for(int i = 0 ; i < arr.get(spot).size(); i++){
                travel(end, arr.get(spot).get(i));
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), m = nextInt(), a = nextInt(), b = nextInt();
        arr = new ArrayList<>();
        madeIt = false;
        beenTo = new boolean[n];
        for(int i = 0; i < n; i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            arr.get(nextInt()-1).add(nextInt()-1);
        }
        travel(b-1, a-1);
        if(madeIt){
            out.println("GO SHAHIR!");
        }
        else{
            out.println("NO SHAHIR!");
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
