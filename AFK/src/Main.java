import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int rows, cols, startR, startC, endR, endC;
    static char[][] map;
    static int[][] steps;

    private static void findShort(int spotR, int spotC, int count){
        if(spotR >= 0 && spotR < rows && spotC >= 0 && spotC < cols && count < 60){
            if(steps[spotR][spotC] >= 0 && count < steps[spotR][spotC]){
                if(map[spotR][spotC] == 'X'){
                    steps[spotR][spotC] = -1;
                }
                else{
                    steps[spotR][spotC] = count;
                    findShort(spotR - 1, spotC, count + 1);
                    findShort(spotR + 1, spotC, count + 1);
                    findShort(spotR, spotC - 1, count + 1);
                    findShort(spotR, spotC + 1, count + 1);
                }
            }

        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0; z < t; z++){
            cols = nextInt();rows = nextInt();
            map = new char[rows][cols];
            steps = new int[rows][cols];
            for(int i = 0 ; i < rows; i++){
                String temp = next();
                for(int o = 0 ; o < cols; o++){
                    if(temp.charAt(o) == 'C'){
                        startR = i;
                        startC = o;
                    }
                    else if(temp.charAt(o) == 'W'){
                        endR = i;
                        endC = o;
                    }
                    map[i][o] = temp.charAt(o);
                    steps[i][o] = Integer.MAX_VALUE;
                }
            }
            findShort(startR, startC, 0);
            if(steps[endR][endC] >= 60){
                out.println("#notworth");
            }
            else{
                out.println(steps[endR][endC]);
            }
        }
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
