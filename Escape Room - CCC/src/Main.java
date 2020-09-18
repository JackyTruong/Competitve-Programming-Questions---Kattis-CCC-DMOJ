
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int rows, col;
    static boolean[] held;
    static int[][] room;
    static boolean[][] beenTo;
    static boolean end;

    private static void escape(int spotRow, int spotCol){
        if(!end && !beenTo[spotRow][spotCol]){
            beenTo[spotRow][spotCol] = true;
            if(spotRow == rows-1 && spotCol == col-1){
                end = true;
            }
            if(!held[room[spotRow][spotCol]]){
                ArrayList<Integer> divs = divisors(room[spotRow][spotCol]);
                for(int i = 0; i < divs.size() && !end; i++){
                    int a = divs.get(i);
                    int b = room[spotRow][spotCol]/a;
                    a--;
                    b--;
                    if(a < rows && b < col){
                        escape(a, b);
                    }
                    if(a < col && b < rows){
                        escape(b, a);
                    }
                }
            }
        }
    }

    private static ArrayList<Integer> divisors(int num){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 1 ; i <= Math.sqrt(num); i++){
                if(num % i == 0 && ((i-1 < rows && num/i-1 < col) || (i-1 < col && num/i-1 < rows))){
                    temp.add(i);
                }
            }
            held[num] = true;
            return temp;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        held = new boolean[1000001];
        rows = nextInt();
        col = nextInt();
        room = new int[rows][col];
        beenTo = new boolean[rows][col];
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < col; o++){
                room[i][o] = nextInt();
                beenTo[i][o] = false;
            }
        }
        escape(0,0);
        if(end){
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
