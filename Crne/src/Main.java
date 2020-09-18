import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int temp = sc.nextInt();
        if(temp == 1){
            System.out.println(2);
        }
        else{
            int out = 2;
            int temp2 = temp-1;
            int add = 2;
            int times = 0;
            while(temp2 > 0){
                if(times == 2){
                    times = 0;
                    add++;
                }
                out+= add;
                times++;
                temp2--;
            }
            System.out.println(out);
        }
    }
}
