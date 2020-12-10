import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static char[][] map;
    static boolean[][] beenTo;
    static int count;

    private static void countOil(int spotR, int spotCol){
        if(spotR >= 0 && spotR < 10 && spotCol >= 0 && spotCol < 10 && (map[spotR][spotCol] == '#' || map[spotR][spotCol] == 'A') && !beenTo[spotR][spotCol]){
            beenTo[spotR][spotCol] = true;
            count++;
            countOil(spotR + 1, spotCol);
            countOil(spotR - 1, spotCol);
            countOil(spotR, spotCol + 1);
            countOil(spotR, spotCol - 1);
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0 ;z < 5; z++){
            beenTo = new boolean[10][10];
            map = new char[10][10];
            count = 0;
            int row = 0;
            int col = 0;
            for(int i = 0 ; i < 10 ;i++){
                map[i] = br.readLine().toCharArray();
                for(int o = 0 ; o < 10; o++){
                    if(map[i][o] == 'A'){
                        row = i;
                        col = o;
                    }
                }
            }
            countOil(row, col);
            out.println(count);
            br.readLine();
        }

        out.close();
    }

}
