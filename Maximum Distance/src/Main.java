
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0; z < t; z++){
            int size = nextInt();
            int highest = 0;
            int[] findexes = new int[size+3];
            int[] sindexes = new int[size+3];
            Arrays.fill(findexes, -1);
            Arrays.fill(sindexes, -1);
            for(int i = 1 ; i <= size; i++){
                int temp = nextInt();
                if(findexes[temp] == -1){
                    findexes[temp] = i;
                }
            }
            for(int i = 1; i <= size; i++){
                int temp = nextInt();
                if(sindexes[temp] == -1 || sindexes[temp] < i){
                    sindexes[temp] = i;
                }
            }
            for(int i = 1; i <= size; i++){
                //System.out.println("here " + sindexes[i] + " " + findexes[i]);
                if(sindexes[i] != -1 && findexes[i] != -1){
                    if(Math.abs(sindexes[i] - findexes[i]) > highest){
                        highest = Math.abs(sindexes[i]-findexes[i]);
                    }
                }
            }
            System.out.println("The maximum distance is " + highest);
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
