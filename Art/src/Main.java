import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int lowestX = Integer.MAX_VALUE;
        int highestX = 0;
        int lowestY = Integer.MAX_VALUE;
        int highestY = 0;
        for(int i = 0 ; i < num; i++){
            st = new StringTokenizer(br.readLine(), ",");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x > highestX){
                highestX = x;
            }
            if(x < lowestX){
                lowestX = x;
            }
            if(y > highestY){
                highestY = y;
            }
            if(y < lowestY){
                lowestY = y;
            }
        }
        System.out.println((lowestX-1) + "," + (lowestY-1));
        System.out.println((highestX+1) + "," + (highestY+1));
    }
}
