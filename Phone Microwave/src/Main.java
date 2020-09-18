import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int year, month, day, hour, min, sec, goBack;

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

    private static void removeDay(){
        day--;
        if(day == 0){
            month--;
            if(month == 0){
                month = 12;
                year--;
            }
            day = manyDays();
        }
        hour += 24;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        goBack = Integer.parseInt(br.readLine());
        StringTokenizer date = new StringTokenizer(next(), "/");
        year = Integer.parseInt(date.nextToken());
        month = Integer.parseInt(date.nextToken());
        day = Integer.parseInt(date.nextToken());
        StringTokenizer time = new StringTokenizer(next(), ":");
        hour = Integer.parseInt(time.nextToken());
        min = Integer.parseInt(time.nextToken());
        sec = Integer.parseInt(time.nextToken());
        hour -= goBack;
        while(hour < 0){
            removeDay();
        }

        out.print(year + "/");
        if(month < 10){
            out.print("0"+month+"/");
        }
        else{
            out.print(month+"/");
        }
        if(day < 10){
            out.print("0"+day+" ");
        }
        else{
            out.print(day+" ");
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
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
