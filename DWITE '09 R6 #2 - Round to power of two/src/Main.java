import java.util.Scanner;

public class Main {

    static int[] arr;

    private static void createArr(){
        int i = 1;
        for(int o = 0 ; o <= 16; o++){
            arr[o] = i;
            i *= 2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[17];
        createArr();
        for(int z = 0 ;z < 5; z++){
            int temp = sc.nextInt();
            int closest = 0;
            for(int i = 0 ; i <= 16; i++){
                if(Math.abs(arr[closest]-temp) >= Math.abs(arr[i]-temp)){
                    closest = i;
                }
            }
            System.out.println(arr[closest]);
        }
    }
}
