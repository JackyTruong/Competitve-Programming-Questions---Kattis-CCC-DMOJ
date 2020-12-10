import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int spotInArr;
    static ArrayList<String> cities;
    static Map<String, Integer> hashmap;

    static class DJS{
        int[] parent;
        int n;

        public DJS(int n){
            parent = new int[n];
            this.n = n;
            for(int i = 0; i < n; i++){
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

    private static int findCity(String name){
        if(!hashmap.containsKey(name)){
            hashmap.put(name, hashmap.size());
        }
        return hashmap.get(name);
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0; z < 5; z++){
            hashmap = new HashMap<>();
            spotInArr = 0;
            int n = Integer.parseInt(next());
            DJS djs = new DJS(100000);
            cities = new ArrayList<>();
            for(int i = 0 ; i < n; i++){
                int letter = next().charAt(0);
                String first = next();
                String second = next();
                int f = findCity(first);
                int s = findCity(second);
                if(letter == 'p'){
                    djs.union(f, s);
                }
                else{
                    if(djs.find(f) == djs.find(s) || first.equals(second)){
                        out.println("connected");
                    }
                    else{
                        out.println("not connected");
                    }
                }

            }
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
