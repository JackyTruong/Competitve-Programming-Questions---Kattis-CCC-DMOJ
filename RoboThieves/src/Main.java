import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int row, col, lowest, startRow, startCol;
    static char[][] map;
    static int[][] dp;

    private static boolean checkCam(int r, int c){
        int i = 0;
        while(map[r][c+i] != 'W'){
            if(map[r][c+i] == 'C'){

                return true;
            }
            i++;
        }
        i = 0;
        while(map[r][c-i] != 'W'){
            if(map[r][c-i] == 'C'){
                //System.out.println("here" + r + " " + c);
                return true;
            }
            i++;
        }
        i = 0;
        while(map[r+i][c] != 'W'){
            if(map[r+i][c] == 'C'){
                return true;
            }
            i++;
        }
        i = 0;
        while(map[r-i][c] != 'W'){
            if(map[r-i][c] == 'C'){
                return true;
            }
            i++;
        }
        return false;
    }

    private static boolean isConveyer(int r, int c){
        if(map[r][c] == 'U' || map[r][c] == 'D' || map[r][c] == 'R' || map[r][c] == 'L'){
            return true;
        }
        return false;
    }

    private static void fill(int r, int c){
        if(map[r][c] != 'W'){
            int up = Integer.MAX_VALUE, down = Integer.MAX_VALUE, left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            if(!isConveyer(r-1,c) || map[r-1][c] == 'D'){
                up = dp[r-1][c];
            }
            if(!isConveyer(r+1,c) || map[r+1][c] == 'U'){
                down = dp[r+1][c];
            }
            if(!isConveyer(r,c-1) || map[r][c-1] == 'R'){
                left = dp[r][c-1];
            }
            if(!isConveyer(r,c+1) || map[r][c+1] == 'L'){
                right = dp[r][c+1];
            }
            int spot;
            boolean conveyer = isConveyer(r,c);
            if(conveyer){
                spot = Math.min(Math.min(up,down),Math.min(left,right));
            }
            else if(Math.min(Math.min(up,down),Math.min(left,right)) != Integer.MAX_VALUE){
                spot = Math.min(Math.min(up,down),Math.min(left,right))+1;
            }
            else{
                spot = Integer.MAX_VALUE;
            }
            if((!checkCam(r,c) || conveyer) && spot < dp[r][c]){
                dp[r][c] = spot;
                fill(r+1, c);
                fill(r-1, c);
                fill(r, c-1);
                fill(r, c+1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        row = nextInt();col = nextInt();
        map = new char[row][col];
        ArrayList<Integer> rowVal = new ArrayList<>();
        ArrayList<Integer> colVal = new ArrayList<>();
        for(int i = 0 ; i < row;i++){
            String temp = next();
            for(int o = 0; o < col; o++){
                map[i][o] = temp.charAt(o);
                if(map[i][o] == '.'){
                    rowVal.add(i);
                    colVal.add(o);
                }
                else if(map[i][o] == 'S'){
                    startRow = i;
                    startCol = o;
                }
            }
        }
        dp = new int[row][col];
        for(int i = 0 ; i < row; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        if(!checkCam(startRow,startCol)){
            dp[startRow][startCol] = 0;
            fill(startRow+1, startCol);
            fill(startRow-1, startCol);
            fill(startRow, startCol-1);
            fill(startRow, startCol+1);
        }
        for(int i = 0 ; i < rowVal.size();i++){
            if(dp[rowVal.get(i)][colVal.get(i)] != Integer.MAX_VALUE && dp[rowVal.get(i)][colVal.get(i)] > 0){
                System.out.println(dp[rowVal.get(i)][colVal.get(i)]);
            }
            else{
                System.out.println(-1);
            }

        }
        /*
        for(int i = 0 ; i < row; i++){
            System.out.println(Arrays.toString(dp[i]));
        }

         */




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
