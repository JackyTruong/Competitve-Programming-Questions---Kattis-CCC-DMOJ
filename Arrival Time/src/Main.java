import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int dist;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), ":");
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        dist = 0;
        int overH = 0;
        int overM = 0;
        if(hour == 5 && min == 0){
        }
        else if(hour >= 5 && hour < 10){
            if(hour >= 7){
                overH += 10-hour;

            }
            else if(hour == 6){
                overH += hour-7+3;
            }
            else{
                overH += hour-7+2;
            }
            overM += min;
        }
        else if(hour == 13 && min == 0){
        }
        else if(hour >= 13 && hour < 19){
            if(hour > 15){
                overH += 17-hour;
            }
            else if(hour == 14){
                overH += hour-13+1;
            }
            else{
                overH+= hour-13+1;
            }
            overM += min;
        }
        int addH = overH/2;
        int diffH = overH - addH*2;
        int addM = overM/2;
        //System.out.println(addH + " " + overH + " " + diffH + " " + addM + " " + overM);
        hour+=2;
        hour+=addH;
        min += diffH*30;

        min += addM*2;
        if(hour >= 24){
            hour -= 24;
        }
        if(min >= 60){
            min -=60;
            hour++;
        }
        if(hour == 10 && min == 20){
            System.out.println("10:10");
        }
        else if(hour < 10){
            System.out.print("0" + hour + ":");
            if(min == 0){
                System.out.println("00");
            }
            else{
                System.out.println(min);
            }
        }
        else{
            System.out.print(hour + ":");
            if(min == 0){
                System.out.println("00");
            }
            else{
                System.out.println(min);
            }
        }

    }
}
