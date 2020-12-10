import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int rows, col;
    static int[][] room;
    static boolean[][] reachable;

    private static ArrayList<Integer> divisors(int num){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1 ; i <= Math.sqrt(num); i++){
            if(num % i == 0 && ((i-1 < rows && num/i-1 < col) || (i-1 < col && num/i-1 < rows))){
                temp.add(i);
            }
        }
        return temp;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        rows = nextInt();
        col = nextInt();
        room = new int[rows][col];
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < col; o++){
                room[i][o] = nextInt();
            }
        }
        reachable = new boolean[rows][col];
        reachable[0][0] = true;
        for(int d = 0; d < rows; d++){
            for(int i = 0 ; i < rows; i++){
                for(int o = 0 ; o < col; o++){
                    if(reachable[i][o]){
                        ArrayList<Integer> temp = divisors(room[i][o]);
                        for(int a = 0 ; a < temp.size();a++){
                            int b = temp.get(a);
                            int c = room[i][o]/b;
                            b--;
                            c--;
                            if(b < rows && c < col){
                                reachable[b][c] = true;
                            }
                            if(b < col && c < rows){
                                reachable[c][b] = true;
                            }
                        }
                    }

                }
            }
        }
        if(reachable[rows-1][col-1]){
            out.println("yes");
        }
        else{
            out.println("no");
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
