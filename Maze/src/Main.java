import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int y, x;
    static String[] map;
    static int[][] steps;

    private static void traverse(int count, int spotY, int spotX){
        if(spotX >= 0 && spotX < x && spotY >= 0 && spotY < y){
            if(steps[spotY][spotX] >= 0 && count < steps[spotY][spotX]){
                if(map[spotY].charAt(spotX) == '*'){
                    steps[spotY][spotX] = -1;
                }
                else if(map[spotY].charAt(spotX) == '+'){
                    steps[spotY][spotX] = count;
                    traverse(count+1, spotY-1, spotX);
                    traverse(count+1, spotY+1, spotX);
                    traverse(count+1, spotY, spotX-1);
                    traverse(count+1, spotY, spotX+1);
                }
                else if(map[spotY].charAt(spotX) == '|'){
                    steps[spotY][spotX] = count;
                    traverse(count+1, spotY-1, spotX);
                    traverse(count+1, spotY+1, spotX);
                }
                else if(map[spotY].charAt(spotX) == '-'){
                    steps[spotY][spotX] = count;
                    traverse(count+1, spotY, spotX-1);
                    traverse(count+1, spotY, spotX+1);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0; z < t; z++){
            y = nextInt();x = nextInt();
            steps = new int[y][x];
            map = new String[y];
            for(int i = 0 ; i < y ; i++){
                Arrays.fill(steps[i], 99999);
                map[i] = next();
            }
            traverse(0, 0, 0);
            if(steps[y-1][x-1] == 99999 || steps[y-1][x-1] == -1){
                out.println(-1);
            }
            else{
                out.println(steps[y-1][x-1]+1);
            }
        }



        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
