import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static String entire;

    private static int valueOf(char c){
        if(c == 'I'){
            return 1;
        }
        else if(c == 'V'){
            return 5;
        }
        else if(c == 'X'){
            return 10;
        }
        else if(c == 'L'){
            return 50;
        }
        else if(c == 'C'){
            return 100;
        }
        else if(c == 'D'){
            return 500;
        }
        else if(c == 'M'){
            return 1000;
        }
        else{
            return -1;
        }
    }

    private static int totalAmount(String s){
        int total = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == 'V' || s.charAt(i) == 'L' || s.charAt(i) == 'D' || s.charAt(i) == 'M'){
                total += valueOf(s.charAt(i));
            }
            else if(s.charAt(i) == 'I'){
                if(i-1 < 0||s.charAt(i-1) != 'I'){
                    if(i+1 < s.length()){
                        if(s.charAt(i+1) == 'V'){
                            total -= valueOf(s.charAt(i));
                        }
                        else if(s.charAt(i+1) == 'X'){
                            total -= valueOf(s.charAt(i));

                        }
                        else{
                            total += valueOf(s.charAt(i));
                        }
                    }
                    else{
                        total += valueOf(s.charAt(i));
                    }

                }
                else{
                    total+=valueOf(s.charAt(i));
                }
            }
            else if(s.charAt(i) == 'X'){
                if(i-1 < 0||s.charAt(i-1) != 'X'){
                    if(i+1 < s.length()){
                        if(s.charAt(i+1) == 'L'){
                            total-= valueOf(s.charAt(i));
                        }
                        else if(s.charAt(i+1) == 'C'){
                            total -= valueOf(s.charAt(i));
                        }
                        else{
                            total += valueOf(s.charAt(i));
                        }
                    }
                    else{
                        total+=valueOf(s.charAt(i));
                    }
                }
                else{
                    total+=valueOf(s.charAt(i));

                }
            }
            else if(s.charAt(i) == 'C'){
                if(i-1 < 0||s.charAt(i-1) != 'C'){
                    if(i+1 < s.length()){
                        if(s.charAt(i+1) == 'D'){
                            total-= valueOf(s.charAt(i));
                        }
                        else if(s.charAt(i+1) == 'M'){
                            total -= valueOf(s.charAt(i));
                        }
                        else{
                            total += valueOf(s.charAt(i));
                        }
                    }
                    else{
                        total += valueOf(s.charAt(i));
                    }
                }
                else{
                    total+=valueOf(s.charAt(i));
                }
            }


        }
        return total;
    }

    private static void romanOutput(int i){
        String temp = "";
        while(i > 0){
            if(i - 1000 >= 0){
                temp += 'M';
                i -= 1000;
            }
            else if(((temp.length() > 1 && temp.charAt(temp.length()-1) != 'C')|| temp.length() < 1) && i - 900 >= 0){
                temp += "CM";
                i -= 900;
            }
            else if(i - 500 >= 0){
                temp += 'D';
                i -= 500;
            }
            else if(((temp.length() > 1 && temp.charAt(temp.length()-1) != 'C')|| temp.length() < 1) && i - 400 >= 0){
                temp += "CD";
                i -= 400;
            }
            else if(i - 100 >= 0){
                temp += 'C';
                i -= 100;
            }
            else if(((temp.length() > 1 && temp.charAt(temp.length()-1) != 'X')|| temp.length() < 1) &&i - 90 >= 0){
                temp += "XC";
                i -= 90;
            }
            else if(i - 50 >= 0){
                temp += 'L';
                i -= 50;
            }
            else if(((temp.length() > 1 && temp.charAt(temp.length()-1) != 'X')|| temp.length() < 1) && i - 40 >= 0){
                temp += "XL";
                i -= 40;
            }
            else if(i - 10 >= 0){
                temp += 'X';
                i -= 10;
            }
            else if(((temp.length() > 1 && temp.charAt(temp.length()-1) != 'I')|| temp.length() < 1) && i - 9 >= 0){
                temp += "IX";
                i -= 9;
            }
            else if(i - 5 >= 0){
                temp += 'V';
                i -= 5;
            }
            else if(((temp.length() > 1 && temp.charAt(temp.length()-1) != 'I')|| temp.length() < 1) && i - 4 >= 0){
                temp += "IV";
                i -= 4;
            }
            else{
                temp += 'I';
                i -= 1;
            }
        }
        System.out.println(entire +temp);
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int z = 0 ; z < num; z++){
            entire = br.readLine();
            StringTokenizer st = new StringTokenizer(entire, "+=");
            int temp = totalAmount(st.nextToken()) + totalAmount(st.nextToken());
            if(temp <= 1000){
                romanOutput(temp);
            }
            else{
                System.out.println(entire +"CONCORDIA CUM VERITATE");
            }
        }
    }
}
