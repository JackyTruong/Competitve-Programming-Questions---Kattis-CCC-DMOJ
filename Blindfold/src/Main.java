import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static Integer[][] place;

    private static void end(String[] back, int direction, char[] move, int r, int c){
        for(int i = 0; i < move.length; i++){
            if(move[i] == 'R'){
                direction++;
                if(direction == 4){
                    direction = 0;
                }
            }
            else if(move[i] == 'L'){
                direction--;
                if(direction  == -1){
                    direction = 3;
                }
            }
            else{
                if(direction == 0){
                    if(r-1 >= 0 && back[r-1].charAt(c) != 'X'){
                        r--;
                    }
                    else{
                        //System.out.println("here?");
                        return;
                    }
                }
                else if(direction == 1){
                    if(c+1 < place[0].length && back[r].charAt(c+1) != 'X'){
                        c++;
                    }
                    else{
                        return;
                    }
                }
                else if(direction == 2 ){
                    if(r+1 < place.length && back[r+1].charAt(c) != 'X'){
                        r++;
                    }
                    else{
                        return;
                    }
                }
                else{
                    if(c-1 >= 0 && back[r].charAt(c-1) != 'X'){
                        c--;
                    }
                    else{
                        return;
                    }
                }
            }
        }
        place[r][c] = 1;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int r = nextInt(), c = nextInt();
        place = new Integer[r][c];
        for(int i = 0; i < r; i++){
            Arrays.fill(place[i], 0);
        }
        String[] back = new String[r];
        for(int i = 0 ; i < r; i++){
            back[i] = next();
        }
        int m = nextInt();
        char[] move = new char[m];
        for(int i = 0 ; i < m; i++){
            move[i] = next().charAt(0);
        }
        for(int i = 0 ; i < r; i++){
            for(int o = 0 ; o < c; o++){
                if(back[i].charAt(o) == '.'){
                    for(int a = 0 ;a < 4;a++){
                        end(back, a, move, i, o);
                    }
                }
                else{
                    place[i][o] = -1;
                }
            }
        }
        for(int i = 0 ; i < r; i++){
            for(int o = 0 ; o < c; o++){
                if(place[i][o] == 0){
                    System.out.print(".");
                }
                else if(place[i][o] == 1){
                    System.out.print("*");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println("");
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
