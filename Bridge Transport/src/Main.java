import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxWeight = sc.nextInt();
        int numTrains = sc.nextInt();
        int[] weights = new int[numTrains];
        for(int i = 0 ; i < numTrains; i++){
            weights[i] = sc.nextInt();
        }
        int weightNow = 0;
        int cars = 0;
        for(int i = 0 ; i < numTrains; i++){
            if(i > 3){
                weightNow -= weights[i-4];
            }
            if(weightNow + weights[i] <= maxWeight){
                weightNow += weights[i];
            }
            else{
                break;
            }
            cars++;
        }
        System.out.println(cars);
    }
}
