
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int year, month, day, hour, min, sec;

    private static boolean isLeap(){
        return year%4==0;
    }

    private static int manyDays(){
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            return 31;
        }
        else if(month == 4 || month == 6 || month == 9 || month == 11){
            return 30;
        }
        else{
            if(isLeap()){
                return 29;
            }
            else{
                return 28;
            }
        }
    }

    private static void lowerSec(){
        sec -= 60;
        min++;
        if(min >= 60){
            hour++;
            min = 0;
        }
        if(hour >= 24){
            day++;
            hour = 0;
        }
        if(manyDays() < day){
            day = 1;
            month++;
        }
        if(month > 12){
            month = 1;
            year++;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int startX = nextInt(), startY = nextInt(), endX = nextInt(), endY = nextInt();
        int timeNeeded = Math.abs(startX-endX) + Math.abs(startY- endY);
        StringTokenizer temp = new StringTokenizer(next(), ":");
        year = Integer.parseInt(temp.nextToken());
        month =Integer.parseInt(temp.nextToken());
        day = Integer.parseInt(temp.nextToken());
        hour = Integer.parseInt(temp.nextToken());
        min = Integer.parseInt(temp.nextToken());
        sec = Integer.parseInt(temp.nextToken());
        sec += timeNeeded;
        while(sec >= 60){
            lowerSec();
        }

        out.print(year + ":");
        if(month < 10){
            out.print("0"+month+":");
        }
        else{
            out.print(month+":");
        }
        if(day < 10){
            out.print("0"+day+":");
        }
        else{
            out.print(day+":");
        }
        if(hour < 10){
            out.print("0"+hour+":");
        }
        else{
            out.print(hour+":");
        }
        if(min < 10){
            out.print("0"+min+":");
        }
        else{
            out.print(min+":");
        }
        if(sec < 10){
            out.println("0"+sec);
        }
        else{
            out.println(sec);
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
