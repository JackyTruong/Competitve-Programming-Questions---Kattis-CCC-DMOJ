import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int steps = sc.nextInt();
        int nSpot = 0;
        int nFowards = 0;
        int bFowards = 0;
        int bSpot = 0;
        for(int i = 0 ; i <= steps; i++){
            //System.out.println(nSpot);
            if(nFowards < a){
                nFowards++;
                nSpot++;
            }
            else{
                for(int o = 0 ; o < b && i <= steps; o++){
                    nSpot--;
                    i++;
                }
                nFowards = 0;
            }
        }
        for(int i = 0 ; i <= steps; i++){

            if(bFowards < c){
                bFowards++;
                bSpot++;
            }
            else{
                for(int o = 0 ; o < d && i <= steps; o++){
                    bSpot--;
                    i++;
                }
                bFowards = 0;
            }
        }
        if(nSpot > bSpot){
            System.out.println("Nikky");
        }
        else if(bSpot > nSpot){
            System.out.println("Byron");
        }
        else{
            System.out.println("Tied");
        }
    }
}
