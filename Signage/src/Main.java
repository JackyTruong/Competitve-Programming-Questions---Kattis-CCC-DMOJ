import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = {"WELCOME", "TO", "CCC", "GOOD", "LUCK", "TODAY"};
        int w = sc.nextInt();
        ArrayList<String> output = new ArrayList<>();
        int i = 1;
        String temp = words[0];
        while(i < 6){
            if((temp+words[i]).length()+1 <= w){
                temp += " ";
                temp += words[i];
            }
            else{
                output.add(temp);
                temp = words[i];
            }

            i++;
        }
        if(!output.contains(temp)){
            output.add(temp);
        }
        for(int o = 0 ; o < output.size();o++){
            StringTokenizer st = new StringTokenizer(output.get(o), " ");
            int space = st.countTokens()-1;
            int dots = w-(output.get(o).length()-space);
            int extra = 0;
            int dotsPer;
            if(space != 0){
                extra = dots%space;
                dotsPer = (dots-extra)/space;
            }
            else{
                dotsPer = dots;
            }
            //System.out.println(dotsPer);
            System.out.print(st.nextToken());
            if(!st.hasMoreTokens()){
                for(int b = 0 ;b < dotsPer; b++){
                    System.out.print(".");
                }
            }
            while(st.hasMoreTokens()){
                for(int b = 0 ;b < dotsPer; b++){
                    System.out.print(".");
                }
                if(extra > 0){
                    System.out.print(".");
                    extra--;
                }
                System.out.print(st.nextToken());
            }
            //System.out.println(space + " " + dots + " " + extra + " " + dotsPer);
            System.out.println("");
        }
    }
}
