import java.util.Scanner;

public class Main {


    private static int strokes(Integer[] clubs, int dist, int n){
       Integer[] f;
       int min, t;

       f = new Integer[dist+1];
       f[0] = 0;
       for(int i = 1; i <= dist; i++){
           min = 999999999;
           for(int o = 0; o < n; o++){
               t = i-clubs[o];
               if(t >= 0 && f[t] >= 0 && f[t] < min){
                   //System.out.println(f[t]);
                   min = f[t];
               }
           }
           if(min < 999999999){
               f[i] = min+1;
           }
           else{
               f[i] = -1;
           }
       }
       return f[dist];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dist = sc.nextInt();
        int n = sc.nextInt();
        Integer[] clubs = new Integer[n];
        for(int i = 0; i < n; i++){
            clubs[i] = sc.nextInt();
        }
       // int[] plays = strokes(clubs, dist, 0, 0);
        int temp = strokes(clubs, dist, n);
        //System.out.println(temp);
        if(temp != -1){
            System.out.println("Roberta wins in " + temp + " strokes.");
        }
         else{
            System.out.println("Roberta acknowledges defeat.");
        }
    }
}
