import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static BufferedReader br;
    static ArrayList<String> shifts;

    private static void findShifts(String s){
        char[] temp = s.toCharArray();
        for(int i = 0 ; i < s.length(); i++){
            String tempAdd = "";
            for(int o = 0; o < s.length(); o++){
                if(i + o >= s.length()){
                    int tempRem = s.length();
                    tempAdd += s.charAt(i+o-tempRem);
                }
                else{
                    tempAdd+= s.charAt(i+o);
                }
            }
            shifts.add(tempAdd);
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String s = br.readLine();
        shifts = new ArrayList<>();
        findShifts(s);
        boolean contains = false;
        for(int i = 0 ; i < shifts.size() && !contains;i ++){
            if(text.contains(shifts.get(i))){
                contains = true;
            }
        }
        if(contains){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
