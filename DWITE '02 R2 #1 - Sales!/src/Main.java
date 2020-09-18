import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static PrintWriter out;
    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < 5; i++){
            double percent = 0;
            for(int o = 0 ;o  < 3; o++){
                double normal = nextDouble();
                double sale = nextDouble();
                double temp = (1.0-(sale/normal))*100;
                if(temp > percent){
                    percent = temp;
                }
            }
            if(percent/10 < 1){
                out.print("  ");
                out.printf("%.03f" , percent);
            }
            else if(percent/100 < 1){
                out.print(" ");
                out.printf("%.03f" , percent);
            }
            else{
                out.printf("%.03f" , percent);
            }

            out.println();
        }



        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static double nextDouble()throws IOException{
        return Double.parseDouble(next());
    }

}
