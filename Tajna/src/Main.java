import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    private static int findR(int len){
        for(int i = (int)Math.sqrt(len) ; 1 < Math.sqrt(len); i--){
            if(len%i == 0){
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String mess = br.readLine();
        int r = findR(mess.length());
        int c = mess.length()/r;
        char[][] temp = new char[r][c];
        int spot = 0;
        for(int i = 0 ; i < c; i++){
            for(int o = 0 ; o < r; o++){
                temp[o][i] = mess.charAt(spot);
                spot++;
            }
        }
        for(int i = 0 ; i < r; i++){
            for(int o = 0 ; o < c; o++){
                System.out.print(temp[i][o]);
            }
        }
    }
}
