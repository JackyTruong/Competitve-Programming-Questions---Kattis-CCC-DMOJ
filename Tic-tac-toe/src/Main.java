import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static String board;

    private static boolean isValid(){
        int O = 0;
        int X = 0;
        for(int i = 0 ; i < 9; i++){
            if(board.charAt(i) == 'O'){
                O++;
            }
            else if(board.charAt(i) == 'X'){
                X++;
            }
        }
        if(O > X){
            return false;
        }
        else if(X-1 > O){
            return false;
        }
        boolean isWinO = false;
        boolean isWinX = false;
        if(board.charAt(0) == 'O' && board.charAt(1) == board.charAt(2) && board.charAt(0) == board.charAt(1)){
            isWinO = true;
        }
        if(board.charAt(0) == 'X' && board.charAt(1) == board.charAt(2) && board.charAt(0) == board.charAt(1)){
            isWinX = true;
        }
        if(board.charAt(3) == 'O' && board.charAt(3) == board.charAt(4) && board.charAt(4) == board.charAt(5)){
            if(isWinO){
                return false;
            }
            else{
                isWinO = true;
            }
        }
        if(board.charAt(3) == 'X' && board.charAt(3) == board.charAt(4) && board.charAt(4) == board.charAt(5)){
            if(isWinX){
                return false;
            }
            else{
                isWinX = true;
            }
        }
        if(board.charAt(6) == 'O' && board.charAt(6) == board.charAt(7) && board.charAt(7) == board.charAt(8)){
            if(isWinO){
                return false;
            }
            else{
                isWinO = true;
            }
        }
        if(board.charAt(6) == 'X' && board.charAt(6) == board.charAt(7) && board.charAt(7) == board.charAt(8)){
            if(isWinX){
                return false;
            }
            else{
                isWinX = true;
            }
        }
        if(board.charAt(0) == 'O' && board.charAt(0) == board.charAt(4) && board.charAt(4) == board.charAt(8)){
            if(isWinO){
                return false;
            }
            else{
                isWinO = true;
            }
        }
        if(board.charAt(0) == 'X' && board.charAt(0) == board.charAt(4) && board.charAt(4) == board.charAt(8)){
            if(isWinX){
                return false;
            }
            else{
                isWinX = true;
            }
        }
        if(board.charAt(2) == 'O' && board.charAt(2) == board.charAt(4) && board.charAt(4) == board.charAt(6)){
            if(isWinO){
                return false;
            }
            else{
                isWinO = true;
            }
        }
        if(board.charAt(2) == 'X' && board.charAt(2) == board.charAt(4) && board.charAt(4) == board.charAt(6)){
            if(isWinX){
                return false;
            }
            else{
                isWinX = true;
            }
        }
        for(int i = 0 ; i < 3; i++){
            if(board.charAt(i) == 'O' && board.charAt(i) == board.charAt(i+3) && board.charAt(i+3) == board.charAt(i+6)){
                if(isWinO){
                    return false;
                }
                else{
                    isWinO = true;
                }
            }
            if(board.charAt(i) == 'X' && board.charAt(i) == board.charAt(i+3) && board.charAt(i+3) == board.charAt(i+6)){
                if(isWinX){
                    return false;
                }
                else{
                    isWinX = true;
                }
            }
        }
        if(isWinO && isWinX){
            return false;
        }
        else if(isWinO && X > O){
            return false;
        }
        else if(isWinX && O >= X){
            return false;
        }
        return true;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++){
            board = br.readLine();
            if(isValid()){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
    }
}
