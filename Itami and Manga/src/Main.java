import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out= new PrintWriter(new OutputStreamWriter(System.out));
        double n = nextDouble();
        String name = "";
        double score = 0;
        for(int i = 0 ; i < n; i++){
            String tempN = next();
            double tempS = nextDouble();
            if(score < tempS){
                name = tempN;
                score = tempS;
            }
        }
        out.println(name);


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st=  new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static double nextDouble()throws IOException{
        return Double.parseDouble(next());
    }

}
