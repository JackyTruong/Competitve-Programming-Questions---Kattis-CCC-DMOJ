import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean magic = true;
        Scanner sc = new Scanner(System.in);
        int[][] square = new int[4][4];
        for(int i = 0 ;  i< 4; i++){
            for(int o = 0; o < 4; o++){
                square[i][o] = sc.nextInt();
            }
        }
        int total = square[0][0] + square[0][1] + square[0][2] + square[0][3];
        for(int i = 0 ; i < 4; i++){
            int row = 0;
            int col = 0;
            for(int o = 0 ; o < 4; o++){
                row += square[i][o];
                col += square[o][i];
            }
            if(row != total){
                magic = false;
            }
            if(col != total){
                magic = false;
            }
        }
        if(magic){
            System.out.println("magic");
        }
        else{
            System.out.println("not magic");
        }
    }
}
