import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[][][] visited;

    private static int piesAway(int people, int pieces, int min){
        if(visited[pieces][people][min] == 0){
            if(pieces == people){
                visited[pieces][people][min] = 1;
            }
            else if(people == 1){
                visited[pieces][people][min] = 1;
            }
            else{
                int temp = 0;
                for(int i = min; i < pieces/people+1; i++){
                    temp += piesAway(people-1, pieces-i, i);
                }
                visited[pieces][people][min] = temp;
            }

        }
        return visited[pieces][people][min];
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int pieces = nextInt();int people = nextInt();
        visited = new int[251][251][251];
        piesAway(people, pieces, 1);
        out.println(piesAway(people, pieces, 1));
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
