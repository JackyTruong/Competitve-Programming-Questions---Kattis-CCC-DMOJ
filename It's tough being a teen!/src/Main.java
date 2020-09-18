import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> before;
    static boolean[] jobsDone;

    private static ArrayList<Integer> jobsCanDo(){
        ArrayList<Integer> canDo = new ArrayList<>();
        for(int i = 1; i < 8; i++){
            boolean shouldAdd = true;
            //System.out.println(before.get(i).size() + " " + i);
            for(int o = 0 ; o < before.get(i).size(); o++){
                if(!jobsDone[before.get(i).get(o)]){
                    shouldAdd = false;
                }
            }
            if(shouldAdd && !jobsDone[i]){
                canDo.add(i);
            }
        }
        return canDo;
    }

    private static boolean isJobsLeft(){
        for(int i = 1 ; i < 8 ; i++){
            if(!jobsDone[i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        jobsDone = new boolean[8];
        Arrays.fill(jobsDone, false);
        before = new ArrayList<>();
        before.add(new ArrayList<>());
        before.add(new ArrayList<>());
        before.add(new ArrayList<>());
        before.add(new ArrayList<>());
        before.add(new ArrayList<>());
        before.add(new ArrayList<>());
        before.add(new ArrayList<>());
        before.add(new ArrayList<>());
        before.get(7).add(1);
        before.get(4).add(1);
        before.get(1).add(2);
        before.get(4).add(3);
        before.get(5).add(3);
        int begin = nextInt();
        int after = nextInt();
        while(begin != 0 && after != 0){
            before.get(after).add(begin);
            begin = nextInt();
            after = nextInt();
        }
        ArrayList<Integer> order = new ArrayList<>();
        while(isJobsLeft()){
            ArrayList<Integer> temp = jobsCanDo();
            if(!temp.isEmpty()){
                order.add(temp.get(0));
                jobsDone[temp.get(0)] = true;
            }
            else{
                break;
            }
        }
        if(order.size() == 7){
            for(int i = 0 ; i < order.size(); i++){
                out.print(order.get(i) + " ");
            }
        }
        else{
            out.println("Cannot complete these tasks. Going to bed.");
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
