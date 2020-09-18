import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < num ; i++){
            String temp = br.readLine();
            int count = 1;
            char what = temp.charAt(0);
            for(int o = 1 ; o < temp.length(); o++){
                if(what == temp.charAt(o)){
                    count++;
                }
                else{
                    System.out.print(count + " " + what + " ");
                    count = 1;
                    what = temp.charAt(o);
                }
                if(o == temp.length()-1){
                    System.out.print(count + " " + what);
                }
            }
            System.out.println("");
        }
    }
}
