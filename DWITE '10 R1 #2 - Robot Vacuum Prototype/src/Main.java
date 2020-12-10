import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int z = 0 ; z < 5; z++){
            String map = br.readLine();
            int spot = 0;
            for(int i = 0 ; i < map.length(); i++){
                if(map.charAt(i) == '*'){
                    spot = i;
                }
            }

            for(int i = 0; i < 5; i++){
                String temp = br.readLine();
                if(temp.charAt(0) == 'L'){
                    if(spot != 0){
                        spot--;
                    }
                }
                if(temp.charAt(0) == 'R'){
                    if(spot != 4){
                        spot++;
                    }
                }
            }
            for(int i = 0 ; i < 5; i++){
                if(i != spot){
                    System.out.print(".");
                }
                else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
