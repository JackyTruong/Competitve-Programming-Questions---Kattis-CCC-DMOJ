import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        for(int i = 0; i < n ; i++){
            boolean canVote = true;
            int year = nextInt();
            int month = nextInt();
            int day = nextInt();
            if(year > 1989){
                canVote = false;
            }
            else if(year == 1989){
                if(month > 2){
                    canVote = false;
                }
                else if(month == 2){
                    if(day > 27){
                        canVote = false;
                    }
                }
            }
            if(canVote){
                out.println("Yes");
            }
            else{
                out.println("No");
            }
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
