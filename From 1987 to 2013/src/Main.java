import java.util.Scanner;

public class Main {

    private static boolean isDistinct(int num){
        String temp = Integer.toString(num);
        for(int i = 0 ;  i < temp.length(); i++){
            for(int o = i+1; o < temp.length();o++){
                if(temp.charAt(i) == temp.charAt(o)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        num++;
        while(!isDistinct(num)){
            num++;
        }
        System.out.println(num);
    }
}
