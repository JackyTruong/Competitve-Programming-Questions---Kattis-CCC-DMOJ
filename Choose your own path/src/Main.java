import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> go;
    static boolean[] been;
    static int lowest;
    private static void throughPages(int pageNum, int count, boolean[] beenTo){
        //System.out.println((pageNum+1) + " " + count);
        if(count < lowest){
            if(!beenTo[pageNum]){
                beenTo[pageNum] = true;
                boolean[] temp = beenTo.clone();
                if(go.get(pageNum).isEmpty() && count < lowest){
                    lowest = count;
                }
                else{
                    for(int i = 0 ; i < go.get(pageNum).size(); i++){
                        throughPages(go.get(pageNum).get(i), count+1, temp);
                    }
                }
            }
        }
    }

    private static void goAble(int i){
        been[i] = true;
        for(int o = 0 ; o < go.get(i).size(); o++){
            if(!been[go.get(i).get(o)]){
                goAble(go.get(i).get(o));
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int pages = nextInt();
        been = new boolean[pages];
        Arrays.fill(been, false);
        boolean[] beenTo = new boolean[pages];
        Arrays.fill(beenTo, false);
        lowest = Integer.MAX_VALUE;
        go = new ArrayList<>();
        for(int i = 0 ; i < pages; i++){
            go.add(new ArrayList<>());
        }
        for(int i = 0 ; i < pages; i++){
            int num = nextInt();
            for(int o = 0 ; o < num; o++){
                int temp = nextInt()-1;
                go.get(i).add(temp);
            }
        }
        goAble(0);
        throughPages(0, 1, beenTo);
        boolean complete = true;
        for(int i = 0 ; i < pages && complete; i++){
            if(!been[i]){
                complete = false;
            }
        }
        if(complete){
            out.println("Y");
            out.println(lowest);
        }
        else{
            out.println("N");
            out.println(lowest);
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
