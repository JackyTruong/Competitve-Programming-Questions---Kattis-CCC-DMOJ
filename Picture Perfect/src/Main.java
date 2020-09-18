import java.util.Scanner;

public class Main {

    private static void minPer(int i){
        int sqrt = (int)Math.sqrt(i);
        int smallPerm = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;
        for(int o = 1 ; o < sqrt+1;o++){
             if(i%o == 0){
                 int other  = i/o;
                 int tempPerm = other*2 + o*2;
                 if(tempPerm < smallPerm){
                     smallPerm = tempPerm;
                     x = o;
                     y = other;
                 }
             }
        }
        System.out.println("Minimum perimeter is " + smallPerm + " with dimensions " + x + " x " + y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while(i != 0){
            minPer(i);
            i = sc.nextInt();
        }
    }
}
