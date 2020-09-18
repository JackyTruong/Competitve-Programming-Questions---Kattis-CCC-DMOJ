import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n;
    static int[][] map;
    static ArrayList<Long> endingMoneys;

    private static void findPath(int spotR, int spotC, long count, boolean[][] stack){
        //System.out.println(spotR + " " + spotC + " " + count);
        if(spotC < n && spotR >= 0 && !stack[spotR][spotC]){
            if(spotR == 0 && spotC == n-1){
                count += map[spotR][spotC];
                addNum(count);
            }
            count += map[spotR][spotC];
            stack[spotR][spotC] = true;
            findPath(spotR - 1 , spotC, count, stack);
            findPath(spotR, spotC+1, count, stack);
            stack[spotR][spotC] = false;
        }
    }

    private static void addNum(long count){
        if(endingMoneys.size() < 5){
            endingMoneys.add(count);
        }
        else{
            Collections.sort(endingMoneys);
            if(count > endingMoneys.get(0)){
                endingMoneys.set(0, count);
            }
        }


    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        map = new int[n][n];
        endingMoneys = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            for(int o = 0 ; o < n; o++){
                map[i][o] = nextInt();
                //System.out.print(map[i][o] + " ");
            }
            //System.out.println();
        }
        findPath(n-1, 0, 0, new boolean[n][n]);
        //Collections.sort(endingMoneys, Collections.reverseOrder());
        for(int i = 4 ; i >= 0; i--){
            System.out.println(endingMoneys.get(i));
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
