import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static char[][] map;
    static boolean[][] beenTo;
    static int[] count;
    static int rows, cols, spot;

    static class Cords{
        int row, col;
        public Cords(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private static void findRoom(int row, int col){
        if(row >= 0 && row < rows && col >= 0 && col < cols && map[row][col] != '#' && !beenTo[row][col]){
            beenTo[row][col] = true;
            count[spot]++;
            findRoom(row +1, col);
            findRoom(row -1, col);
            findRoom(row, col+1);
            findRoom(row, col-1);
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        rows = Integer.parseInt(next()); cols = Integer.parseInt(next());
        map = new char[rows][cols];
        Cords[] RMI = new Cords[5];
        count = new int[5];
        beenTo = new boolean[rows][cols];
        for(int i = 0 ; i < rows; i++){
            map[i] = next().toCharArray();
            for(int o = 0 ; o < cols; o++){
                if(map[i][o] == '1'){
                    RMI[0] = new Cords(i, o);
                }
                else if(map[i][o] == '2'){
                    RMI[1] = new Cords(i,o);
                }
                else if(map[i][o] == '3'){
                    RMI[2] = new Cords(i,o);
                }
                else if(map[i][o] == '4'){
                    RMI[3] = new Cords(i,o);
                }
                else if(map[i][o] == '5'){
                    RMI[4] = new Cords(i,o);
                }
            }
        }
        spot = 0;
        for(; spot < 5; spot++){
            findRoom(RMI[spot].row, RMI[spot].col);
        }
        for(int i = 0 ; i < 5; i++){
            out.println(count[i]);
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
