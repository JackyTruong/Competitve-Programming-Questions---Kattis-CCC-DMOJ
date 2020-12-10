import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static class DJS{
        int[] parent;
        int n;

        public DJS(int n){
            parent = new int[n];
            this.n = n;
            for(int i = 0 ; i < n; i++){
                parent[i] = i;
            }
        }

        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y){
            int xR = find(x);
            int yR = find(y);
            if(xR == yR){
                return;
            }
            parent[yR] = xR;
        }

    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(); int q = nextInt();
        DJS djs = new DJS(n);
        for(int z = 0 ;z < q; z++){
            char temp = next().charAt(0);
            if(temp == 'A'){
                int first = nextInt()-1;
                int second = nextInt()-1;
                djs.union(first, second);
            }
            else{
                int first = nextInt()-1;
                int second = nextInt()-1;
                if(djs.find(first) == djs.find(second)){
                    out.println("Y");
                }
                else{
                    out.println("N");
                }
            }
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
