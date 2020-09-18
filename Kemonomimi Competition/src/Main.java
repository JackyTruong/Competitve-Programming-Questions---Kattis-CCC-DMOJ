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
        int[] cats = new int[4];
        for(int i = 0; i < 4; i++){
            cats[i] = nextInt();
        }
        int[] catP = new int[n];
        int[] baseP = new int[n];
        int[] time = new int[n];
        int wakeUp = 0;
        for(int i = 0;i < n; i++){
            catP[i] = nextInt()-1;
            baseP[i] = nextInt();
            int temp = nextInt();
            if(temp  > wakeUp){
                wakeUp = temp;
            }
            time[i] = nextInt();
        }
        for(int i = 0 ; i < n; i++){
            if(baseP[i] == 10){
                out.println(0);
            }
            else if(wakeUp + (time[i] * cats[catP[i]]) <= 180){
                out.println(10-baseP[i]);
            }
            else{
                out.println("The kemonomimi are too cute!");
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
