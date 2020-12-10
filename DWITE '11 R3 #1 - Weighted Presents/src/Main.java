import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0 ; z < 5; z++){
            int n = nextInt();
            String closestName = "";
            int closestWeight = 999999999;
            for(int i = 0; i < 4; i++){
                String name=  next();
                int weight = nextInt();
                if(Math.abs(n - closestWeight) > Math.abs(n - weight)){
                    closestName = name;
                    closestWeight = weight;
                }
            }
            out.println(closestName);
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
