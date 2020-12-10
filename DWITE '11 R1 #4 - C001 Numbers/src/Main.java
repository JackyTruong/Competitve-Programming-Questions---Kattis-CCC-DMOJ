import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int z = 0 ;z < 5 ;z++){
            int n = sc.nextInt();
            int coolness = 0;
            for(int i = 0 ; i <= n; i++){
                String temp = Integer.toString(i);
                for(int o = 0 ; o < temp.length(); o++){
                    if(temp.charAt(o) == '0'){
                        coolness++;
                    }
                }
            }
            System.out.println(coolness);
        }
    }
}
