import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    private static boolean isSet(int first, int second, int setNum){
        if(setNum != 3 && ((first == 7 && second == 6) || (second == 7 && first ==6))){
            return true;
        }
        else if(setNum != 3 && (first > 7 || second > 7)){
            return false;
        }
        else if((first >= 6 && second <= first-2) || (second >= 6 && first <= second-2)){
            return true;
        }
        return false;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        String firstP = next();
        String secondP = next();
        int matches = Integer.parseInt(next());
        for(int i = 0 ; i < matches; i++){
            boolean isMatch = true;
            StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
            int num = 1;
            int setWonF = 0, setWonS = 0;
            while(temp.hasMoreTokens()){
                StringTokenizer second = new StringTokenizer(temp.nextToken(), ":");
                int firstScore = Integer.parseInt(second.nextToken());
                int secondScore = Integer.parseInt(second.nextToken());
                if(firstP.equals("federer") && setWonS > 0){
                    isMatch = false;
                }
                else if(secondP.equals("federer") && setWonF > 0){
                    isMatch = false;
                }
                if(isSet(firstScore, secondScore, num)){
                    if(firstScore > secondScore){
                        setWonF++;
                    }
                    else{
                        setWonS++;
                    }
                }
                else{
                    isMatch = false;
                    break;
                }
                if(num > 3){
                    isMatch = false;
                    break;
                }
                num++;
            }
            if(setWonF != 2 && setWonS != 2){
                isMatch = false;
            }
            if(isMatch){
                out.println("da");
            }
            else{
                out.println("ne");
            }
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}
