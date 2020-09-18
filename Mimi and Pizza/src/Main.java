import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine()), p = Integer.parseInt(br.readLine());
        String veg = br.readLine();
        if(veg.equals("Y")){
            if(b >= 5 * p){
                System.out.println("B");
            }
            else if(b >= 2 * p){
                System.out.println("D");
            }
            else{
                System.out.println("NO PIZZA");
            }
        }
        else{
            if(b >= 5 * p){
                System.out.println("A");
            }
            else if(b >= 2 * p){
                System.out.println("C");
            }
            else{
                System.out.println("NO PIZZA");
            }
        }
    }
}
