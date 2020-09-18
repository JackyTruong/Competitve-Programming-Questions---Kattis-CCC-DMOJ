import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), SL = nextInt(), itami = nextInt();
        ArrayList<ArrayList<Integer>> lead = new ArrayList<>();
        for(int i = 0; i < SL; i++){
            lead.add(new ArrayList<>());
        }
        ArrayList<Integer> pick = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            pick.add(nextInt());
        }
        Collections.sort(pick, Collections.reverseOrder());
        int spot = 0;
        while(!pick.isEmpty()){
            if(spot >= SL){
                spot = 0;
            }
            lead.get(spot).add(pick.remove(0));
            spot++;
        }
        int count = 0;
        for(int i = 0 ; i < lead.get(itami-1).size(); i++){
            count+=lead.get(itami-1).get(i);
        }
        out.println(count);

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
