import java.io.*;
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
            int xR = find(x), yR = find(y);
            if(xR == yR){
                return;
            }
            parent[yR] = xR;
        }


    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0 ;z < 2; z++){
            int num = nextInt();
            int[] nums = new int[100001];
            DJS djs = new DJS(num);
            for(int i = 0 ; i < num; i++){
                djs.union(nextInt()-1, i);
            }
            for(int i = 0 ; i < num; i++){
                int parent = djs.find(i);
                nums[parent] = 1;
            }
            int count = 0;
            for(int i = 0 ; i < 100001; i++){
                if(nums[i] != 0){
                    count++;
                }
            }
            out.print(count + " ");
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
