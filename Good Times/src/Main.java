import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        System.out.println(time + " in Ottawa");
        time -= 300;
        if(time < 0){
            time += 2400;
        }
        System.out.println(time+ " in Victoria");
        time += 100;
        if(time > 2359){
            time -= 2400;
        }
        System.out.println(time + " in Edmonton");
        time += 100;
        if(time > 2359){
            time -= 2400;
        }
        System.out.println(time + " in Winnipeg");
        time += 100;
        if(time > 2359){
            time -= 2400;
        }
        System.out.println(time + " in Toronto");
        time += 100;
        if(time > 2359){
            time -= 2400;
        }
        System.out.println(time + " in Halifax");
        time += 30;
        if(time > 2359){
            time -= 2400;
        }
        if(time == 275){
            time = 315;
        }
        System.out.println(time + " in St. John's");
    }
}
