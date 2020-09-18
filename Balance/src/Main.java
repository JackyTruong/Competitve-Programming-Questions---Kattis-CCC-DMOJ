import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String force = br.readLine();
        LinkedList<Character> temp = new LinkedList<>();
        for(int i = 0 ; i < force.length(); i++){
            if(temp.isEmpty()){
                temp.add(force.charAt(i));
            }
            else{
                if(force.charAt(i) == ')' && temp.get(temp.size()-1) == '('){
                    temp.removeLast();
                }
                else{
                    temp.add(force.charAt(i));
                }
            }
        }
        if(temp.isEmpty()){
            System.out.println("YES");
        }
        else{
            if(temp.size() == 2 && ((temp.get(0) == ')' && temp.get(1) == ')') || (temp.get(0) == '(' && temp.get(1) == '('))){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
