import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++){
            String temp = br.readLine().trim();
            if(temp.equals("Scissors")){
                System.out.println("Rock");
            }
            else if(temp.equals("Rock")){
                System.out.println("Paper");
            }
            else if(temp.equals("Paper")){
                System.out.println("Scissors");
            }
            else if(temp.equals("Fox")){
                System.out.println("Foxen");
            }
            else{
                break;
            }
        }
    }
}
