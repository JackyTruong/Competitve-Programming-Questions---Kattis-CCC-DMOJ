import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static boolean[][] map;
    static int size;

    private static void fillMap(int row, int col){
        fillDown(row, col);
        fillDownLeft(row, col);
        fillDownRight(row, col);
        fillLeft(row, col);
        fillRight(row, col);
        fillUp(row, col);
        fillUpLeft(row,col);
        fillUpRight(row,col);
    }

    private static void fillLeft(int row, int col){
        while(col >= 0){
            map[row][col] = true;
            col--;
        }
    }

    private static void fillRight(int row, int col){
        while(col < size){
            map[row][col] = true;
            col++;
        }
    }

    private static void fillDown(int row, int col){
        while(row < size){
            map[row][col] = true;
            row++;
        }
    }

    private static void fillUp(int row, int col){
        while(row >= 0){
            map[row][col] = true;
            row--;
        }
    }

    private static void fillUpRight(int row, int col){
        while(row >= 0 && col < size){
            map[row][col] = true;
            row--;
            col++;
        }
    }

    private static void fillUpLeft(int row, int col){
        while(row >= 0 && col >= 0){
            map[row][col] = true;
            row--;
            col--;
        }
    }

    private static void fillDownLeft(int row, int col){
        while(row < size && col >= 0){
            map[row][col] = true;
            row++;
            col--;
        }
    }

    private static void fillDownRight(int row, int col){
        while(row < size && col < size){
            map[row][col] = true;
            row++;
            col++;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        size = nextInt();
        int num = nextInt();
        map = new boolean[size][size];
        for(int i = 0 ; i < num;i++){
            int row = nextInt()-1;
            int col = nextInt()-1;
            fillMap(row, col);
        }
        int count = 0;
        for(int i = 0 ; i < size; i++){
            for(int o = 0 ; o < size; o++){
                if(!map[i][o]){
                    count++;
                }
            }
        }
        out.println(count);

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
