import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void rotateMatrix(Integer mat[][] ,int N)
    {
        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++)
        {
            // Consider elements in group of 4 in
            // current square
            for (int y = x; y < N-x-1; y++)
            {
                // store current cell in temp variable
                int temp = mat[x][y];

                // move values from right to top
                mat[x][y] = mat[y][N-1-x];

                // move values from bottom to right
                mat[y][N-1-x] = mat[N-1-x][N-1-y];

                // move values from left to bottom
                mat[N-1-x][N-1-y] = mat[N-1-y][x];

                // assign temp to left
                mat[N-1-y][x] = temp;
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        int i;
        File file = new File("s2.03.IN");
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        Integer[][] numbers = new Integer[i][i];
        for(int o = 0; o < i; o++){
            for(int l = 0 ; l < i; l++){
                numbers[o][l] = sc.nextInt();
            }
        }
        int b = 0;
        //TOP LEFT
        int c = numbers[0][0];
        //BOTTOM RIGHT
        if(numbers[i-1][i-1] < c){
            c = numbers[i-1][i-1];
            b = 1;
        }
        //BOTTOM LEFT
        if(numbers[0][i-1] < c){
            c = numbers[0][i-1];
            b = 2;
        }
        //TOP RIGHT
        if(numbers[i-1][0] < c){
            c = numbers[i-1][0];
            b = 3;
        }
        if(b == 1){
            rotateMatrix(numbers, i);
            rotateMatrix(numbers, i);
        }
        else if(b == 2){
            rotateMatrix(numbers, i);
        }
        else if(b == 3){
            rotateMatrix(numbers, i);
            rotateMatrix(numbers, i);
            rotateMatrix(numbers, i);
        }
        for(int a = 0; a < i; a++){
            for(int t = 0; t < i; t++){
                System.out.print(numbers[a][t] + " ");
            }
            System.out.println();
        }
       //System.out.println(Arrays.deepToString(numbers));
    }
}
