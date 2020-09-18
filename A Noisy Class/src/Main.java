import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<ArrayList<Integer>> cons;
    static boolean cycle;
    static int n;

    private static boolean findCycle(int i, boolean[] beenTo, boolean[] stack){
        if(stack[i]){
            return true;
        }
        if(beenTo[i]){
            return false;
        }
        beenTo[i] = true;
        stack[i] = true;
        for(int o = 0 ; o < cons.get(i).size(); o++){
            if(findCycle(cons.get(i).get(o), beenTo, stack)){
                return true;
            }
        }
        stack[i] = false;
        return false;
    }

    private static boolean isCyclic(){
        boolean[] beenTo = new boolean[n];
        boolean[] stack = new boolean[n];
        for(int i = 0; i < n; i++){
            if(findCycle(i, beenTo, stack)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        cons = new ArrayList<>();
        for(int i = 0; i < n; i++){
            cons.add(new ArrayList<>());
        }
        cycle = false;
        int m = nextInt();
        for(int i = 0 ; i < m; i++){
            int from = nextInt()-1;
            int to = nextInt()-1;
            if(!cons.get(from).contains(to)){
                cons.get(from).add(to);
            }

        }

        if(isCyclic()){
            out.println("N");
        }
        else{
            out.println("Y");
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
