import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static String p1, p2;

    private static Integer[] findCount(String p1){
        Integer[] count = new Integer[10];
        Arrays.fill(count, 0);
        for(int i = 0 ; i < 2; i++){
            if(p1.charAt(i) == 'A'){
                count[0]++;
            }
            else if(p1.charAt(i) == 'a'){
                count[1]++;
            }
        }
        for(int i = 0 ; i < 2; i++){
            if(p1.charAt(i+2) == 'B'){
                count[2]++;
            }
            else if(p1.charAt(i+2) == 'b'){
                count[3]++;
            }
        }
        for(int i = 0 ; i < 2; i++){
            if(p1.charAt(i+4) == 'C'){
                count[4]++;
            }
            else if(p1.charAt(i+4) == 'c'){
                count[5]++;
            }
        }
        for(int i = 0 ; i < 2; i++){
            if(p1.charAt(i+6) == 'D'){
                count[6]++;
            }
            else if(p1.charAt(i+6) == 'd'){
                count[7]++;
            }
        }
        for(int i = 0 ; i < 2; i++){
            if(p1.charAt(i+8) == 'E'){
                count[8]++;
            }
            else if(p1.charAt(i+8) == 'e'){
                count[9]++;
            }
        }
        return count;
    }

    private static void isChild(String s){
        Integer[] countP1 = findCount(p1);
        Integer[] countP2 = findCount(p2);
        boolean isKid = true;
        int spot = 0;
        for(int i = 0 ; i < s.length();i++){
            if(Character.isUpperCase(s.charAt(i))){
                if(countP1[spot+i] < 1 && countP2[spot+i] < 1){
                    isKid = false;
                }
            }
            else{
                if(countP1[i+1+spot] < 1 || countP2[i+1+spot] < 1){
                    isKid = false;
                }
            }
            spot++;
        }
        if(isKid){
            out.println("Possible baby.");
        }
        else{
            out.println("Not their baby!");
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        p1 = next(); p2 = next();
        int n = nextInt();
        for(int i = 0 ; i < n; i++){
            String s = next();
            isChild(s);
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
