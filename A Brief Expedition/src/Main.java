import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int rows, cols;
    static char[][] map;
    static int[][] dp;
    static ArrayList<Pair> stores;

    static class Pair{
        int row, col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    //TODO NEEDA SOMEHOW OPTIMIZE THIS CUZ AS IS IT TAKES TOO LONG FOR 1 000 000 CHECKS

    private static void fillDp(int row, int col, int count){
        if(row >= 0 && row < rows && col >= 0 && col < cols && count < dp[row][col] && map[row][col] != '#'){
            dp[row][col] = count;
            fillDp(row-1, col, count+1);
            fillDp(row +1, col, count+1);
            fillDp(row, col-1, count+1);
            fillDp(row, col + 1, count+1);
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        for(int z = 0 ; z < n; z++){
            rows = nextInt();cols = nextInt();
            map = new char[rows][cols];
            dp = new int[rows][cols];
            stores = new ArrayList<>();
            int carR = 0;
            int carC = 0;
            for(int i = 0 ; i < rows; i++){
                map[i] = next().toCharArray();
                for(int o = 0 ; o < cols; o++){
                    dp[i][o] = 9999999;
                    if(map[i][o] == 'S'){
                        stores.add(new Pair(i, o));
                    }
                    else if(map[i][o] == 'C'){
                        carR = i;
                        carC = o;
                    }
                }
            }
            fillDp(carR, carC, 0);
            /*
            for(int i = 0 ; i < rows; i++){
                for(int o = 0 ; o < cols; o++){
                    System.out.print(dp[i][o] + " ");
                }
                System.out.println();
            }

             */
            int total = 0;
            int largest = 0;
            for(int i = 0 ; i < stores.size(); i++){
                int temp = dp[stores.get(i).row][stores.get(i).col];
                if(temp > largest){
                    largest = temp;
                }
                //System.out.println(dp[stores.get(i).row][stores.get(i).col]);
                total += temp;
            }
            total *= 2;
            total += 60 * stores.size();
            total -= largest;
            out.println(total);
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
