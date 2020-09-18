

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int king = sc.nextInt(), queen = sc.nextInt(), rook = sc.nextInt(), bish = sc.nextInt(), knight = sc.nextInt(), pawn = sc.nextInt();
        if(king != 1){
            System.out.print(((king-1)*-1) + " ");
        }
        else{
            System.out.print("0 ");
        }
        if(queen != 1){
            System.out.print(((queen-1)*-1) + " ");
        }
        else{
            System.out.print("0 ");
        }
        if(rook != 2){
            System.out.print(((rook-2)*-1) + " ");
        }
        else{
            System.out.print("0 ");
        }
        if(bish != 2){
            System.out.print(((bish-2)*-1) + " ");
        }
        else{
            System.out.print("0 ");
        }
        if(knight != 2){
            System.out.print(((knight-2)*-1) + " ");
        }
        else{
            System.out.print("0 ");
        }
        if(pawn != 8){
            System.out.print(((pawn-8)*-1) + " ");
        }
        else{
            System.out.print("0 ");
        }
    }
}
