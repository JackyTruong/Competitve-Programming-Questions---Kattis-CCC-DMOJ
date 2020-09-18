import java.util.Scanner;

public class Main {

    static int spot;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        spot = 1;
        for(int i = 0 ; i < temp.length(); i++){
            if(temp.charAt(i) == 'A' && spot == 1){
                spot = 2;
            }
            else if(temp.charAt(i) == 'A' && spot == 2){
                spot = 1;
            }
            else if(temp.charAt(i) == 'B' && spot == 2){
                spot = 3;
            }
            else if(temp.charAt(i) == 'B' && spot == 3){
                spot = 2;
            }
            else if(temp.charAt(i) == 'C' && spot == 3){
                spot = 1;
            }
            else if(temp.charAt(i) == 'C' && spot == 1){
                spot = 3;
            }
        }
        System.out.println(spot);
    }
}
