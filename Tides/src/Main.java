import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int[] readings = new int[n];
        int lowest = 10001;
        int lowSpot = 0;
        int highest = 0;
        int highSpot = 0;
        for(int i = 0 ; i < n; i++){
            readings[i] = nextInt();
            if(lowest > readings[i]){
                lowest = readings[i];
                lowSpot = i;
            }
            if(highest < readings[i]){
                highest = readings[i];
                highSpot = i;
            }
        }
        boolean works = true;
        if(highSpot > lowSpot){
            for(int i = lowSpot+1; i <= highSpot && works; i++){
                if(readings[i] < readings[i-1]){
                    works = false;
                }
            }
        }else{
            works = false;
        }

        if(works){
            out.println(highest-lowest);
        }
        else{
            out.println("unknown");
        }



        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
