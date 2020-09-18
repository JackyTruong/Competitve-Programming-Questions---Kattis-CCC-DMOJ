
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static String word, output;

    private static boolean isVowel(char A){
        if(A == 'a' || A == 'e' || A == 'i' || A == 'o' || A == 'u'){
            return true;
        }
        return false;
    }

    private static char closestCon(char A){
        int tempFor = A;
        tempFor++;
        while(isVowel((char)tempFor)){
            tempFor++;
        }
        if(A == 'z'){
            return 'z';
        }
        return (char)tempFor;
    }

    private static char closestVow(char A){
        int tempFor = A;
        int tempBef = A;
        tempFor++;
        while(!isVowel((char)tempFor)){
            tempFor++;
        }
        tempBef--;
        while(!isVowel((char)tempBef)){
            tempBef--;
        }
        if(Math.abs(A-tempBef) <= Math.abs(A-tempFor)){
            return (char)tempBef;
        }
        else{
            return (char)tempFor;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        output = "";
        for(int i = 0 ; i < word.length(); i++){
            if(!isVowel(word.charAt(i))){
                output += word.charAt(i);
                output += closestVow(word.charAt(i));
                output += closestCon(word.charAt(i));
            }
            else{
                output += word.charAt(i);
            }

        }
        System.out.println(output);
    }
}
