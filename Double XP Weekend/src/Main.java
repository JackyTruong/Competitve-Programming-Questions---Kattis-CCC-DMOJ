import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int CE = Integer.parseInt(br.readLine()), DE = Integer.parseInt(br.readLine()), CB = Integer.parseInt(br.readLine()), E = Integer.parseInt(br.readLine()), C = Integer.parseInt(br.readLine());
        long fishBought = 0;
        while(CE < DE){
            if(CB > 0){
                if(CB >= E){
                    CB -= E;
                    CE += E*3;
                }
                else{
                    CE += E*2 + CB;
                    CB = 0;
                }
            }
            else{
                //System.out.println(fishBought);
                CE += E*2;
            }

            fishBought++;
        }
        System.out.println(fishBought);
        System.out.println(fishBought*C);
    }
}
