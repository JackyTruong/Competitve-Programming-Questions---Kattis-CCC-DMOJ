import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int rows, cols;
    static char[][] map;
    static int[][] nums;

    private static void fillDP(){
        int[][] dp = new int[rows][cols];
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < cols; o++){
                dp[i][o] = -1;
            }
        }
        dp[rows-1][0] = nums[rows-1][0];
        for(int i = rows-2; i >= 0; i--){
            if(nums[i][0] >= 0){
                dp[i][0] = dp[i+1][0] + nums[i][0];
            }
            else{
                break;
            }
        }

        for(int co = 1; co < cols; co++){
            for(int ro = 0; ro < rows; ro++){
                if(dp[ro][co-1] >= 0){
                    int temp = dp[ro][co-1];
                    for(int a = ro; a < rows; a++){
                        if(nums[a][co] >=0){
                            temp += nums[a][co];
                            if(temp > dp[a][co]){
                                dp[a][co] = temp;
                            }
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            for(int ro = rows-1; ro >= 0; ro--){
                if(dp[ro][co-1] >= 0){
                    int temp = dp[ro][co-1];
                    for(int a = ro; a >= 0; a--){
                        if(nums[a][co] >=0){
                            temp += nums[a][co];
                            if(temp > dp[a][co]){
                                dp[a][co] = temp;
                            }
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        /*
        for(int i = 0 ; i < rows; i++){
            for(int o = 0 ; o < cols; o++){
                System.out.print(dp[i][o] + " ");
            }
            System.out.println("");
        }


         */
        out.println(dp[rows-1][cols-1]);
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
         rows = nextInt();cols=nextInt();
         while(rows != 0 && cols != 0){
             map = new char[rows][cols];
             nums = new int[rows][cols];
             boolean[][] beenTo = new boolean[rows][cols];
             for(int i = 0 ; i < rows; i++){
                 map[i] = next().toCharArray();
             }
             for(int i = 0 ; i < rows; i++){
                 for(int o = 0 ; o < cols; o++){
                     if(map[i][o] == '.'){
                         nums[i][o] = 0;
                     }
                     else if(map[i][o] == '*'){
                         nums[i][o] = -1;
                     }
                     else{
                         nums[i][o] = Character.getNumericValue(map[i][o]);
                     }
                 }
             }

             //System.out.println(dp[rows-1][cols-1]);



            fillDP();


             rows = nextInt();
             cols = nextInt();
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
