import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cities = new int[5];
        for(int i = 1; i <= 4; i++){
            cities[i] = sc.nextInt();
        }
        for(int a = 0 ; a < 5; a++){
            int dist = cities[a];
            for(int i = 0 ; i < 5; i++){
                int total = 0;
                if(i < a){
                    for(int o = i+1; o <= a; o++){
                        total += cities[o];
                    }
                    System.out.print(total + " ");
                }
                else{
                    for(int o = i; o >= a; o--){
                        total += cities[o];
                    }
                    System.out.print(Math.abs(dist-total) + " ");
                }


            }
            System.out.println("");
        }

    }
}
