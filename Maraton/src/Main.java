import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int n;
    static char[][] map;
    static char winner;

    private static void win(){
        boolean keepGo = true;
        for(int i = 0 ; i < n && keepGo; i++){
            for(int o = 0 ; o < n && keepGo; o++){
                if(checkBotLeft(i, o) || checkBotRight(i, o) || checkDown(i, o) || checkLeft(i, o) || checkRight(i, o) || checkTopLeft(i,o) || checkTopRight(i, o) || checkUp(i, o)){
                    keepGo = false;
                }
            }
        }
        if(keepGo){
            out.println("ongoing");
        }
        else{
            out.println(winner);
        }
    }

    private static boolean checkLeft(int row, int col){
        if(col - 2 >= 0 && map[row][col] != '.'){
            char temp = map[row][col];
            boolean diff = false;
            for(int i = 0 ; i < 3; i++){
                if(map[row][col-i] != temp){
                    diff = true;
                }
            }
            if(!diff){
                winner = map[row][col];
            }
            return !diff;
        }
        else{
            return false;
        }
    }

    private static boolean checkRight(int row, int col){
        if(col + 2 < n && map[row][col] != '.'){
            char temp = map[row][col];
            boolean diff = false;
            for(int i = 0 ; i < 3; i++){
                if(map[row][col+i] != temp){
                    diff = true;
                }
            }
            if(!diff){
                winner = map[row][col];
            }
            return !diff;
        }
        else{
            return false;
        }
    }

    private static boolean checkUp(int row, int col){
        if(row - 2 >= 0 && map[row][col] != '.'){
            char temp = map[row][col];
            boolean diff = false;
            for(int i = 0 ; i < 3; i++){
                if(map[row-i][col] != temp){
                    diff = true;
                }
            }
            if(!diff){
                winner = map[row][col];
            }
            return !diff;
        }
        else{
            return false;
        }
    }

    private static boolean checkDown(int row, int col){
        if(row + 2 < n && map[row][col] != '.'){
            char temp = map[row][col];
            boolean diff = false;
            for(int i = 0 ; i < 3; i++){
                if(map[row+i][col] != temp){
                    diff = true;
                }
            }
            if(!diff){
                winner = map[row][col];
            }
            return !diff;
        }
        else{
            return false;
        }
    }

    private static boolean checkTopLeft(int row, int col){
        if(row-2 >= 0 && col - 2 >= 0 && map[row][col] != '.'){
            char temp = map[row][col];
            boolean diff = false;
            for(int i = 0 ; i < 3; i++){
                if(map[row-i][col-i] != temp){
                    diff = true;
                }
            }
            if(!diff){
                winner = map[row][col];
            }
            return !diff;
        }
        else{
            return false;
        }
    }

    private static boolean checkBotLeft(int row, int col){
        if(row+2 < n && col - 2 >= 0 && map[row][col] != '.'){
            char temp = map[row][col];
            boolean diff = false;
            for(int i = 0 ; i < 3; i++){
                if(map[row+i][col-i] != temp){
                    diff = true;
                }
            }
            if(!diff){
                winner = map[row][col];
            }
            return !diff;
        }
        else{
            return false;
        }
    }

    private static boolean checkTopRight(int row, int col){
        if(row-2 >= 0 && col + 2 < n && map[row][col] != '.'){
            char temp = map[row][col];
            boolean diff = false;
            for(int i = 0 ; i < 3; i++){
                if(map[row-i][col+i] != temp){
                    diff = true;
                }
            }
            if(!diff){
                winner = map[row][col];
            }
            return !diff;
        }
        else{
            return false;
        }
    }

    private static boolean checkBotRight(int row, int col){
        if(row+2 < n && col + 2 < n && map[row][col] != '.'){
            char temp = map[row][col];
            boolean diff = false;
            for(int i = 0 ; i < 3; i++){
                if(map[row+i][col+i] != temp){
                    diff = true;
                }
            }
            if(!diff){
                winner = map[row][col];
            }
            return !diff;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        map = new char[n][n];
        for(int i = 0 ; i < n; i++){
            map[i] = next().toCharArray();
        }
        win();

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
