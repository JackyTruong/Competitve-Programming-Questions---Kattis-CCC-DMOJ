import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        for(int i = 1; i < num-2; i++){
            for(int o = i; o < num-1; o++){
                for(int a = o; a < num; a++){
                    if(a != o && o != i){
                        //System.out.println(i + " " + o + " " + a);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
