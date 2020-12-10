import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        if (S.equals("Y")) {
            System.out.println(T.toUpperCase());
        }
        else {
            System.out.println(T);
        }
    }
}
