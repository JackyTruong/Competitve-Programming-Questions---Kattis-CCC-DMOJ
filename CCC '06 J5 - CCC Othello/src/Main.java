import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[][] board;
    static int turn;

    private static void placePiece(int r, int c){
        if(turn % 2 == 0){
            //TODO blacks turn
            board[r][c] = 1;
            int up = 0;
            boolean u = true;
            int down = 0;
            boolean d = true;
            int right = 0;
            boolean ri = true;
            int left = 0;
            boolean l = true;

            int uR = 0;
            boolean uRa = true;
            int uL = 0;
            boolean uLa = true;
            int bR = 0;
            boolean bRa = true;
            int bL = 0;
            boolean bLa = true;

            for(int i = 1 ; i < 8; i++){
                if(up != -1 && u){
                    if(r+i < 8){
                       if(board[r+i][c] == 0){
                            up = -1;
                        }
                       else if(board[r+i][c] == 1){
                           u = false;
                       }
                    }
                    else{
                        up = -1;
                    }
                }
                if(down != -1 && d){
                    if(r-i >= 0){
                        if(board[r-i][c] == 0){
                            down = -1;
                        }
                        else if(board[r-i][c] == 1){
                            d = false;
                        }
                    }
                    else{
                        down = -1;
                    }
                }
                if(right != -1 && ri){
                    if(c+i < 8){
                        if(board[r][c+i] == 0){
                            right =  -1;
                        }
                        else if(board[r][c+i] == 1){
                            ri = false;
                        }
                    }
                    else{
                        right =  -1;
                    }
                }
                if(left != -1 && l){
                    if(c-i >= 0){
                        if(board[r][c-i] == 0){
                            System.out.println();
                            left =  -1;
                        }
                        else if(board[r][c-i] == 1){
                            l = false;
                        }
                    }
                    else{
                        left =  -1;
                    }
                }
                if(bR != -1 && bRa){
                    if(r + i < 8 && c + i < 8){
                        if(board[r+i][c+i] == 0){
                            bR =  -1;
                        }
                        else if(board[r+i][c+i] == 1){
                            bRa = false;
                        }
                    }
                    else{
                        bR =  -1;
                    }
                }
                if(uR != -1 && uRa){
                    if(r - i >= 0 && c + i < 8){
                        if(board[r-i][c+i] == 0){
                            uR =  -1;
                        }
                        else if(board[r-i][c+i] == 1){
                            uRa = false;
                        }
                    }
                    else{
                        uR =  -1;
                    }
                }
                if(uL != -1 && uLa){
                    if(r - i >= 0 && c - i >= 0){
                        if(board[r-i][c-i] == 0){
                            uL =  -1;
                        }
                        else if(board[r-i][c-i] == 1){
                            uLa = false;
                        }
                    }
                    else{
                        uL =  -1;
                    }
                }
                if(bL != -1 && bLa){
                    if(r + i < 8 && c - i >= 0){
                        if(board[r+i][c-i] == 0){
                            bL =  -1;
                        }
                        else if(board[r+i][c-i] == 1){
                            bLa = false;
                        }
                    }
                    else{
                        bL =  -1;
                    }
                }
                if(up != -1 && u){
                    up++;
                }
                if(down != -1 && d){
                    down++;
                }
                if(right != -1 && ri){
                    right++;
                }
                if(left != -1 && l){
                    left++;
                }
                if(uR != -1 && uRa){
                    uR++;
                }
                if(uL != -1 && uLa){
                    uL++;
                }
                if(bL != -1 && bLa){
                    bL++;
                }
                if(bR != -1 && bRa){
                    bR++;
                }
            }
            if(up != -1){
                for(int i = 0 ; i <= up; i++){
                    board[r+i][c] = 1;
                }
            }
            if(down != -1){
                for(int i = 0 ; i <= down; i++){
                    board[r-i][c] = 1;
                }
            }
            if(right != -1){
                for(int i = 0 ; i <= right; i++){
                    board[r][c+i] = 1;
                }
            }
            if(left != -1){
                for(int i = 0 ; i <= left; i++){
                    board[r][c-i] = 1;
                }
            }
            if(uR != -1){
                for(int i = 0 ; i <= uR; i++){
                    board[r-i][c+i] = 1;
                }
            }
            if(uL != -1){
                for(int i = 0 ; i <= uL; i++){
                    board[r-i][c-i] = 1;
                }
            }
            if(bL != -1){
                for(int i = 0 ; i <= bL; i++){
                    board[r+i][c-i] = 1;
                }
            }
            if(bR != -1){
                for(int i = 0 ; i <= bR; i++){
                    board[r+i][c+i] = 1;
                }
            }
        }
        else {
            //TODO whites turn
            board[r][c] = 2;
            int up = 0;
            boolean u = true;
            int down = 0;
            boolean d = true;
            int right = 0;
            boolean ri = true;
            int left = 0;
            boolean l = true;

            int uR = 0;
            boolean uRa = true;
            int uL = 0;
            boolean uLa = true;
            int bR = 0;
            boolean bRa = true;
            int bL = 0;
            boolean bLa = true;

            for (int i = 1; i < 8; i++) {
                if (up != -1 && u) {
                    if (r + i < 8) {
                        if (board[r + i][c] == 0) {
                            up = -1;
                        } else if (board[r + i][c] == 2) {
                            u = false;
                        }
                    } else {
                        up = -1;
                    }
                }
                if (down != -1 && d) {
                    if (r - i >= 0) {
                        if (board[r - i][c] == 0) {
                            down = -1;
                        } else if (board[r - i][c] == 2) {
                            d = false;
                        }
                    } else {
                        down = -1;
                    }
                }
                if (right != -1 && ri) {
                    if (c + i < 8) {
                        if (board[r][c + i] == 0) {
                            right = -1;
                        } else if (board[r][c + i] == 2) {
                            ri = false;
                        }
                    } else {
                        right = -1;
                    }
                }
                if (left != -1 && l) {
                    if (c - i >= 0) {
                        if (board[r][c - i] == 0) {
                            left = -1;
                        } else if (board[r][c - i] == 2) {
                            l = false;
                        }
                    } else {
                        left = -1;
                    }
                }
                if (bR != -1 && bRa) {
                    if (r + i < 8 && c + i < 8) {
                        if (board[r + i][c + i] == 0) {
                            bR = -1;
                        } else if (board[r + i][c + i] == 2) {
                            bRa = false;
                        }
                    } else {
                        bR = -1;
                    }
                }
                if (uR != -1 && uRa) {
                    if (r - i >= 0 && c + i < 8) {
                        if (board[r - i][c + i] == 0) {
                            uR = -1;
                        } else if (board[r - i][c + i] == 2) {
                            uRa = false;
                        }
                    } else {
                        uR = -1;
                    }
                }
                if (uL != -1 && uLa) {
                    if (r - i >= 0 && c - i >= 0) {
                        if (board[r - i][c - i] == 0) {
                            uL = -1;
                        } else if (board[r - i][c - i] == 2) {
                            uLa = false;
                        }
                    } else {
                        uL = -1;
                    }
                }
                if (bL != -1 && bLa) {
                    if (r + i < 8 && c - i >= 0) {
                        if (board[r + i][c - i] == 0) {
                            bL = -1;
                        } else if (board[r + i][c - i] == 2) {
                            bLa = false;
                        }
                    } else {
                        bL = -1;
                    }
                }
                if (up != -1 && u) {
                    up++;
                }
                if (down != -1 && d) {
                    down++;
                }
                if (right != -1 && ri) {
                    right++;
                }
                if (left != -1 && l) {
                    left++;
                }
                if (uR != -1 && uRa) {
                    uR++;
                }
                if (uL != -1 && uLa) {
                    uL++;
                }
                if (bL != -1 && bLa) {
                    bL++;
                }
                if (bR != -1 && bRa) {
                    bR++;
                }
            }
            if (up != -1) {
                for (int i = 0; i <= up; i++) {
                    board[r + i][c] = 2;
                }
            }
            if (down != -1) {
                for (int i = 0; i <= down; i++) {
                    board[r - i][c] = 2;
                }
            }
            if (right != -1) {
                for (int i = 0; i <= right; i++) {
                    board[r][c + i] = 2;
                }
            }
            if (left != -1) {
                for (int i = 0; i <= left; i++) {
                    board[r][c - i] = 2;
                }
            }
            if (uR != -1) {
                for (int i = 0; i <= uR; i++) {
                    board[r - i][c + i] = 2;
                }
            }
            if (uL != -1) {
                for (int i = 0; i <= uL; i++) {
                    board[r - i][c - i] = 2;
                }
            }
            if (bL != -1) {
                for (int i = 0; i <= bL; i++) {
                    board[r + i][c - i] = 2;
                }
            }
            if (bR != -1) {
                for (int i = 0; i <= bR; i++) {
                    board[r + i][c + i] = 2;
                }
            }
        }
        turn++;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        char boardT = next().charAt(0);
        board = new int[8][8];

        //TODO Black = 1 White = 2 Open Space = 0
        //TODO turns start on black then switch etc

        if(boardT == 'a'){
            board[3][4] = 1;
            board[3][3] = 2;
            board[4][3] = 1;
            board[4][4] = 2;
        }
        else if(boardT == 'b'){
            for(int i = 0 ; i < 8; i++){
                board[i][i] = 1;
                board[7-i][i] = 2;
            }
        }
        else if(boardT == 'c'){
            for(int i = 0 ; i < 8; i++){
                board[i][2] = 1;
                board[i][3] = 1;
                board[i][4] = 2;
                board[i][5] = 2;
            }
        }
        int moves = nextInt();
        turn = 0;

        //TODO if turn % 2 = 0 it is black turn else white turn

        for(int i = 0 ; i < moves; i++){
            int r = nextInt()-1;
            int c = nextInt()-1;
            placePiece(r, c);
        }
        int white = 0;
        int black = 0;
        for(int i = 0 ; i < 8; i++){
            for(int o = 0 ; o < 8; o++){
                if(board[i][o] == 1){
                    black++;
                }
                else if(board[i][o] == 2){
                    white++;
                }
            }
        }

        out.println(black + " " + white);


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
