import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, T;
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        T = nextInt();
        for(int i = 0 ; i < T; i++){
            int N = nextInt();
            int[] people = new int[N];
            int count = 0;
            for(int o = 0 ; o < N; o++){
                people[o] = nextInt();
            }
            int highest = people[0];
            if(N > 1){
                if(people[0] > people[1]){
                    count++;
                }
                for(int o = 1; o < N-1 ; o++){
                    if(people[o] > highest && people[o] > people[o+1]){
                        count++;
                    }
                    if(highest < people[o]){
                        highest = people[o];
                    }
                }
                if(people[N-1] > highest){
                    count++;
                }
            }
            else{
                count = 1;
            }
            out.println("Case #" + (i+1) + ": " + count);
        }


        out.close();
    }

    private static String next()throws IOException {
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }


}
