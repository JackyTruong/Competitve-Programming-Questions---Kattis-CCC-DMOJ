import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;
    static int longest;

    private static boolean isPalindrome(String s){
        boolean isPal = true;
        for(int i = 0 ; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                isPal=false;
            }
        }
        return isPal;
    }

    private static void findLongest(String s){
        if(isPalindrome(s) && s.length() > longest){
            longest = s.length();

        }
        if(s.length() > 1 && longest < s.length()){
            findLongest(s.substring(1));
            findLongest(s.substring(0, s.length()-1));
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        longest = 0;
        findLongest(word);
        System.out.println(longest);
    }
}
