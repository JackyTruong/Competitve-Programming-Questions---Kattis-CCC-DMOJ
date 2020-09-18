import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer temp = new StringTokenizer(br.readLine(), "X");
        System.out.println(temp.countTokens());
        while(temp.hasMoreTokens()){
            System.out.println(temp.nextToken());
        }
    }
}
