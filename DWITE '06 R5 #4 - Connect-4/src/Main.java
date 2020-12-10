import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[][] board;
    static int turn;

    private static boolean vertical(int row, int col){
        int isWin = 0;
        int isWinD = 0;
        int color = board[row][col];
        for(int i = 0 ; i < 4; i++){
            if(row + i < 6 && board[row+i][col] == color){
                isWin++;
            }
            if(row - i >= 0 && board[row-i][col] == color){
                isWinD++;
            }
        }
        if(isWin == 4 || isWinD == 4){
            return true;
        }
        return false;
    }

    private static boolean horizontal(int row,int col){
        int isWin = 0;
        int isWinL = 0;
        int color = board[row][col];
        for(int i = 0 ; i < 4; i++){
            if(col + i < 7 && board[row][col+i] == color){
                isWin++;
            }
            if(col - i >= 0 && board[row][col-i] == color){
                isWinL++;
            }
        }
        if(isWin == 4 || isWinL == 4){
            return true;
        }
        return false;
    }

    private static boolean diagonal(int row, int col){
        int isWinTR = 0, isWinTL = 0, isWinBR = 0, isWinBL = 0;
        int color = board[row][col];
        for(int i = 0 ; i < 4; i++){
            //System.out.println((row-i) + " " + (col+i));
                if(row - i >= 0 && col + i < 7 && board[row-i][col+i] == color){
                    //System.out.println("THIS " + board[row-i][col+i] + " " + isWinBR);
                    isWinBR++;
                }
                if(row + i < 6 && col + i < 7 && board[row+i][col+i] == color){
                    isWinTR++;
                }
                if(row + i < 6 && col - i >= 0 && board[row+i][col-i] == color){
                    isWinTL++;
                }
                if(row - i >= 0 && col - i >= 0 && board[row-i][col-i] == color){
                    isWinBL++;
                }
        }
        //System.out.println(isWinBR  + " " +  isWinTR + " " + isWinTL + "  " + isWinBL + " " + color);
        if(isWinBR == 4 || isWinTR == 4 || isWinTL == 4 || isWinBL == 4){
            return true;
        }
        return false;
    }

    private static void fill(int col){
        boolean placed = false;
        int row = 0;
        while(!placed){
            if(board[row][col] == 0){
                if(turn % 2 == 0){
                    board[row][col] = 1;
                }
                else{
                    board[row][col] = 2;
                }
                placed = true;
            }
            else{
                row++;
            }
        }
        /*
        for(int i = 5 ; i >= 0; i--){
            for(int o = 0; o < 7 ;o++){
                System.out.print(board[i][o] + " ");
            }
            System.out.println();
        }

        System.out.println();

         */
    }

    //RED FIRST THEN BLUE SECOND

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0 ; z < 5; z++){
            board = new int[6][7];
            turn = 0;
            String plays = br.readLine();
            boolean done = false;
            for(int i = 0 ; i < plays.length() && !done; i++){
                fill(Character.getNumericValue(plays.charAt(i)-1));
                for(int a = 0 ; a < 6 && !done; a++){
                    for(int b = 0 ; b < 7 && !done; b++){
                        if(board[a][b] != 0 && (horizontal(a, b) || vertical(a, b) || diagonal(a, b))){
                            if(turn % 2 == 0){
                                out.println("RED-" + (i+1));
                            }
                            else{
                                out.println("BLUE-"+(i+1));
                            }
                            done =true;
                        }
                    }
                }
                turn++;
            }
        }

        out.close();
    }

}
