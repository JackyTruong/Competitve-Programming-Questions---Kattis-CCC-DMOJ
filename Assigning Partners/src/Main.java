import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static String[] first, second;
    static int num;

    private static boolean isRepeat(String firstS, String secondS){
        for(int i = 0 ; i < num; i++){
            if(first[i].equals(firstS)){
                if(!second[i].equals(secondS)){
                    return true;
                }
            }
            if(first[i].equals(secondS)){
                if(!second[i].equals(firstS)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        num = nextInt();
        first = new String[num];
        second = new String[num];
        for(int i = 0 ; i < num; i++){
            first[i] = next();
        }
        for(int i = 0 ; i < num ; i++){
            second[i] = next();
        }
        boolean isGood = true;
        for(int i = 0 ; i < num; i++){
            if(isRepeat(first[i], second[i])){
                isGood = false;
            }
            if(first[i].equals(second[i])){
                isGood = false;
            }
        }
        if(isGood){
            System.out.println("good");
        }
        else{
            System.out.println("bad");
        }
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
