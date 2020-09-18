import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int baseS = Integer.parseInt(br.readLine());
        String direct = br.readLine();
        int landedDiff = Integer.parseInt(br.readLine());
        if(direct.equals("Infront")){
            System.out.println(baseS-landedDiff);
        }
        else{
            System.out.println(baseS+landedDiff);
        }
    }
}
