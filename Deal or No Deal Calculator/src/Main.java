import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 1691600;
        for(int i = 0 ; i < n ; i++){
            int temp = sc.nextInt();
            if(temp == 1){
                total-= 100;
            }
            else if(temp == 2){
                total-= 500;
            }
            else if(temp == 3){
                total-= 1000;
            }
            else if(temp == 4){
                total-= 5000;
            }
            else if(temp == 5){
                total-= 10000;
            }
            else if(temp == 6){
                total-= 25000;
            }
            else if(temp == 7){
                total-= 50000;
            }
            else if(temp == 8){
                total-= 100000;
            }
            else if(temp == 9){
                total-= 500000;
            }
            else if(temp == 10){
                total-= 1000000;
            }
        }
        //System.out.println(total);
        total /= (10-n);

        int offer = sc.nextInt();
        if(offer > total){
            System.out.println("deal");
        }
        else{
            System.out.println("no deal");
        }
    }
}
