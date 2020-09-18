
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int startH = Integer.parseInt(st.nextToken());
        int startM = Integer.parseInt(st.nextToken());
        int startS = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(),  ":");
        int endH = Integer.parseInt(st.nextToken());
        int endM = Integer.parseInt(st.nextToken());
        int endS = Integer.parseInt(st.nextToken());
        int finalH, finalM, finalS;
        if(endS < startS){
            finalS = (60-startS)+endS;
            endM--;
        }
        else{
            finalS = endS-startS;
        }
        if(endM < startM){
            finalM = (60-startM)+endM;
            endH--;
        }
        else{
            finalM = endM-startM;
        }
        if(endH < startH){
            finalH = (24-startH)+endH;
        }
        else{
            finalH = endH-startH;
        }
        if(finalH != 0 || finalM != 0 || finalS != 0){
            if(finalH < 10){
                System.out.print("0" +finalH + ":");
            }
            else{
                System.out.print(finalH + ":");
            }
            if(finalM < 10){
                System.out.print("0"+finalM+":");
            }
            else{
                System.out.print(finalM+":");
            }
            if(finalS < 10){
                System.out.println("0"+finalS);
            }
            else{
                System.out.println(finalS);
            }
        }
        else{
            System.out.println("24:00:00");
        }

        //System.out.println(finalH + " " + finalM + " " + finalS);
    }
}
