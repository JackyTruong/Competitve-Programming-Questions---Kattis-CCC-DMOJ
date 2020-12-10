import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static Map<String, Integer> hashmap;

    private static void addWord(String word){
        if(!hashmap.containsKey(word)){
            hashmap.put(word, hashmap.size());
        }
    }

    private static boolean findWord(String word){
        if(hashmap.containsKey(word)){
            return true;
        }
        return false;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), m = nextInt();
        hashmap = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            addWord(next());
        }
        for(int i = 0 ; i < m; i++){
            if(!findWord(next())){
                out.print((i+1) + " ");
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

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }

    private static double nextDouble()throws IOException{
        return Double.parseDouble(next());
    }

}
