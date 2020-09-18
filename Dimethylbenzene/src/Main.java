import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n, m;
    static Connection[] cons;
    static boolean[] beenTo;
    static boolean found;

    static class Connection{
        int num;
        ArrayList<Integer> connected;
        public Connection(int num){
            this.num = num;
            connected = new ArrayList<>();
        }
        public void addCon(int add){
            connected.add(add);
        }
    }

    private static void findSixCycle(int numBeg, int count, int spot){
        if(!found){
            if(spot == numBeg && count == 5){
                found = true;
            }
            else if(!beenTo[spot] && spot != numBeg){
                beenTo[spot] = true;
                for(int i = 0 ; i < cons[spot].connected.size();i++){
                    findSixCycle(numBeg, count + 1, cons[spot].connected.get(i));
                }
            }
        }

    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();m = nextInt();
        cons = new Connection[n];
        for(int i = 0; i < n; i++){
            cons[i] = new Connection(i);
        }
        for(int i = 0 ; i < m; i++){
            int first = nextInt()-1;
            int second= nextInt()-1;
            cons[first].addCon(second);
            cons[second].addCon(first);
        }
        found = false;
        for(int i = 0 ; i < n && !found; i++){
            beenTo = new boolean[n];
            for(int o = 0 ; o < cons[i].connected.size();o++){
                findSixCycle(i, 0, cons[i].connected.get(o));
            }
        }
        if(found){
            out.println("YES");
        }else{
            out.println("NO");
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
