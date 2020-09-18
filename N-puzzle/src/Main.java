import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static char[][] puz;

    private static int scatter(int row, int col, char letter){
        if(letter == 'A'){
            return row+col;
        }
        else if(letter == 'B'){
            return Math.abs(Math.abs(row) + Math.abs(col-1));
        }
        else if(letter == 'C'){
            return Math.abs(Math.abs(row) + Math.abs(col-2));
        }
        else if(letter == 'D'){
            return Math.abs(Math.abs(row) + Math.abs(col-3));
        }
        else if(letter == 'E'){
            return Math.abs(Math.abs(row-1) + Math.abs(col));
        }
        else if(letter == 'F'){
            return Math.abs(Math.abs(row-1) + Math.abs(col-1));
        }
        else if(letter == 'G'){
            return Math.abs(Math.abs((row-1)) + Math.abs((col-2)));
        }
        else if(letter == 'H'){
            return Math.abs(Math.abs(row-1) + Math.abs(col-3));
        }
        else if(letter == 'I'){
            return Math.abs(Math.abs(row-2) + Math.abs(col));
        }
        else if(letter == 'J'){
            return Math.abs(Math.abs(row-2) + Math.abs(col-1));
        }
        else if(letter == 'K'){
            return Math.abs(Math.abs(row-2) + Math.abs(col-2));
        }
        else if(letter == 'L'){
            return Math.abs(Math.abs(row-2) + Math.abs(col-3));
        }
        else if(letter == 'M'){
            return Math.abs(Math.abs(row-3) + Math.abs(col));
        }
        else if(letter == 'N'){
            return Math.abs(Math.abs(row-3) + Math.abs(col-1));
        }
        else if(letter == 'O'){
            return Math.abs(Math.abs(row-3) + Math.abs(col-2));
        }
        return 0;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        puz = new char[4][4];
        for(int i = 0 ; i < 4;i++){
            puz[i] = next().toCharArray();
        }
        int scatter = 0;
        for(int i = 0 ; i < 4; i++){
            for(int o = 0 ; o < 4; o++){
                scatter += scatter(i, o, puz[i][o]);
            }
        }
        out.println(scatter);

        out.close();
    }

    private static String next()throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
