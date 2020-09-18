import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int startRow, startCol, endRow, endCol;
    static int[][] beenTo;

    private static void findShortest(int spotRow, int spotCol, int count){
        //System.out.println((spotRow) + " " + (spotCol) + " " + count);
        if(spotRow <= 8 && spotRow > 0 && spotCol <= 8 && spotCol > 0 && count < beenTo[spotRow][spotCol]){
            beenTo[spotRow][spotCol] = count;
            findShortest(spotRow-2, spotCol-1, count+1);
            findShortest(spotRow-2, spotCol+1, count+1);
            findShortest(spotRow+1, spotCol-2, count+1);
            findShortest(spotRow+1, spotCol+2, count+1);
            findShortest(spotRow-1, spotCol-2, count+1);
            findShortest(spotRow-1, spotCol+2, count+1);
            findShortest(spotRow+2, spotCol+1, count+1);
            findShortest(spotRow+2, spotCol-1, count+1);
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        startRow = nextInt();startCol = nextInt();endRow = nextInt();endCol = nextInt();
        beenTo = new int[9][9];
        for(int i = 0 ; i < 9; i++){
            Arrays.fill(beenTo[i], Integer.MAX_VALUE);
        }
        findShortest(startRow, startCol, 0);
        out.println(beenTo[endRow][endCol]);

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
