import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static char[] lifeSpan(char[] cells){
            char[] copy = new char[cells.length];
            for(int o = 0; o < cells.length;o++){
                copy[o] = '0';
                if(o == 0){
                    if((cells[o+1] == '0' && cells[cells.length-1] == '1') || (cells[o+1] == '1' && cells[cells.length-1] == '0')){
                        copy[o] = '1';
                    }
                }
                else if(o == cells.length-1){
                    if((cells[o-1] == '0' && cells[0] == '1') || (cells[o-1] == '1' && cells[0] == '0')){
                        copy[o] = '1';
                    }
                }
                else if((cells[o+1] == '0' && cells[o-1] == '1') || (cells[o+1] == '1' && cells[o-1] == '0') ){
                    copy[o] = '1';
                }
        }

        return copy;
    }

    public static void main(String[] args) {
        //NEED TO OPTIMIZE THIS
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long t =  sc.nextLong();
        sc.nextLine();
        String input = sc.nextLine();

        char[] cells;
        cells = input.toCharArray();
        for(long i = 0 ; i < t; i++){
            cells = lifeSpan(cells);
            System.out.println(Arrays.toString(cells));
        }
        for(int i = 0 ; i < cells.length;i++){
            System.out.print(cells[i]);
        }

    }
}
