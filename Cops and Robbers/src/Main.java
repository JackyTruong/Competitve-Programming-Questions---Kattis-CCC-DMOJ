import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int guardedSpot;
    static ArrayList<Integer> guards;
    static boolean[] used;
    static int[] seq;

    private static int whichToRob(){
        for(int i = 0 ; i < guards.size(); i++){
            if(guardedSpot == guards.get(i)){
                if(i == 0 && !used[guards.get(guards.size()-1)]){
                    used[guards.get(guards.size()-1)] = true;
                    return guards.get(guards.size()-1);
                }
                else if(i != 0 && !used[guards.get(i-1)]){
                    used[guards.get(i-1)] = true;
                    return guards.get(i-1);
                }
            }
        }
        for(int i = 1; i < used.length; i++){
            //System.out.println("here");
            if(!used[i]){
                used[i] = true;
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        boolean[] guarded = new boolean[n+1];
        guards = new ArrayList<>();
        int[] arr = new int[n+1];
        for(int i = 0; i < n; i++){
            arr[i] = nextInt();

            if(!guarded[arr[i]]){
                guarded[arr[i]] = true;
                guards.add(arr[i]);
            }
        }
        if(guards.size() == 1){
            out.println(-1);
        }
        else{
            Collections.sort(guards);
            used = new boolean[n+1];
            seq = new int[n];
            for(int i = 0 ; i < n; i++){
                guardedSpot = arr[i];
                seq[i] = whichToRob();
            }
            for(int i = 0 ; i < seq.length; i++){
                out.print(seq[i] + " ");
            }
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st  = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
