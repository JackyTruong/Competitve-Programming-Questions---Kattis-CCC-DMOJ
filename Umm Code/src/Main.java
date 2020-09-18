import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] words = line.split("\\W+");
        String msg = "";
        for(int i = 0 ; i < words.length;i++){
            if(isDiff(words[i])){
                char[] letters = words[i].toCharArray();
                for(int o = 0 ; o < letters.length;o++){
                    if(letters[o] == 'u'){
                        msg += "1";
                    }
                    else{
                        msg += "0";
                    }
                }
                //System.out.println(msg);
            }

           // System.out.println(words[i]);
        }
        for(int i = 0; i < msg.length()/7;i++){
            String temp = msg.substring(i*7, (i+1)*7);
            System.out.print(((char)Integer.parseInt(temp, 2)));
        }
    }

    public static boolean isDiff(String temp){
        char[] array = temp.toCharArray();
        for(int i = 0; i < array.length; i++){
            if(array[i] != 'u' && array[i] != 'm' && array[i] != '.' && array[i] != ',' && array[i] != '?' && array[i] != '!' && array[i] != '(' && array[i] != ')' && array[i] != '-' && array[i] != ';' && array[i] != ':'){
                return false;
            }
        }
        return true;
    }


}
