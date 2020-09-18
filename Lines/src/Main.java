
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        long count = 0;
        ArrayList<Integer> slopes = new ArrayList<>();
        ArrayList<Integer> k = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            int slope = nextInt();
            int tempK = nextInt();
            for(int o = 0 ; o < slopes.size(); o++){
                if(slope != slopes.get(o)){
                    count++;
                }
                else{
                    if(tempK == k.get(o)){
                        out.println("Infinity");
                        out.close();
                        return;
                    }
                }
            }
            slopes.add(slope);
            k.add(tempK);
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
