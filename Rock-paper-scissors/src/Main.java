import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int winner;

    private static void winner(String bob, String alice){
        if(bob.equals("rock")){
            if(alice.equals("paper")){
                 winner = 1;
            }
            else if(alice.equals("scissors")){
                winner = -1;
            }
        }
        else if(bob.equals("scissors")){
            if(alice.equals("rock")){
                winner = 1;
            }
            else if(alice.equals("paper")){
                winner = -1;
            }
        }
        else if(bob.equals("paper")){
            if(alice.equals("scissors")){
                winner = 1;
            }
            else if(alice.equals("rock")){
                winner = -1;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int A = 0;
        int B = 0;
        String[] alice = new String[n];
        String[] bob = new String[n];
        for(int i = 0 ; i < n; i++){
            alice[i] = next();
        }
        for(int i = 0 ; i < n; i++){
            bob[i] = next();
        }
        for(int i = 0 ; i  < n; i++){
            winner = 0;
            winner(bob[i], alice[i]);
            if(winner == 1){
                A++;
            }
            else if(winner == -1){
                B++;
            }
        }
        out.println(A + " " + B);


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
