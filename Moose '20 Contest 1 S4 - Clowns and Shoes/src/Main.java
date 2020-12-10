import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;


    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), m = nextInt();
        ArrayList<Integer>[] shoes = new ArrayList[m+1];
        for(int i = 0 ; i < m+1; i++){
            shoes[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n; i++){
            shoes[nextInt()].add(nextInt());
        }
        for(int i = 1 ; i < m+1; i++){
            Collections.sort(shoes[i]);
        }
        int missingShoes = 0;
        int foundShoes = 0;
        for(int i = 0 ; i < n; i++){
            int fav = nextInt(), size = nextInt();
            boolean found = false;
            for(int o = shoes[fav].size()-1; o >= 0 ; o--){
                if(shoes[fav].get(o) <= size){
                    found = true;
                }
                shoes[fav].remove(o);
            }
            if(!found){
                missingShoes++;
            }
            else{
                foundShoes++;
            }
        }
        if(foundShoes < missingShoes){
            out.println(0);
        }
        else{
            out.println(foundShoes);
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
