import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int week = sc.nextInt(), days = sc.nextInt();
        System.out.println(week + " " + days);
        System.out.println("Sun " + "Mon " + "Tue " + "Wed " + "Thr " + "Fri " + "Sat ");
        for(int i = 1; i < week; i++){
            System.out.print("    ");
        }
        System.out.print("  ");
        for(int i = 1 ; i <= days; i++){
            System.out.print(i);
            if(i < days){
                if(week < 7){
                    if(i < 9){
                        System.out.print("   ");
                    }
                    else{
                        System.out.print("  ");
                    }
                }
                else{
                    week = 0;
                    System.out.println();
                    if(i < 9){
                        System.out.print("  ");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
            }
            week++;
        }
        System.out.println();
    }
}
