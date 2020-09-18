import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static int timeTaken(String s){
        int time = 0;
        int prevLet = -2;
        for(int i = 0 ; i < s.length();i++){
            int tempNum = (int)s.charAt(i) - 96;
            //System.out.println(prevLet);
            int timeCount = tempNum;
            if(tempNum <= 3){
                if(prevLet == -1){
                    time+=2;
                }
                prevLet = -1;
            }
            else if(tempNum < 7){
                if(prevLet == 0){
                    time+=2;
                }
                tempNum -= 3;
                timeCount = tempNum;
                prevLet = 0;
            }
            else if(tempNum < 10){
                if(prevLet == 1){
                    time+=2;
                }
                tempNum -= 6;
                timeCount = tempNum;
                prevLet = 1;
            }
            else if(tempNum < 13){
                if(prevLet == 2){
                    time+=2;
                }
                tempNum -= 9;
                timeCount = tempNum;
                prevLet = 2;
            }
            else if(tempNum < 16){
                if(prevLet == 3){
                    time+=2;
                }

                tempNum -= 12;
                timeCount = tempNum;
                prevLet = 3;
            }
            else if(tempNum < 20){
                if(prevLet == 4){
                    time+=2;
                }

                tempNum -= 15;
                timeCount = tempNum;
                prevLet = 4;
            }
            else if(tempNum < 23){
                //System.out.println("here");
                if(prevLet == 5){
                    time+=2;
                }
                tempNum -= 19;
                timeCount = tempNum;
                prevLet = 5;
            }
            else{
                if(prevLet == 6){
                    time+=2;
                }
                tempNum -= 22;
                timeCount = tempNum;
                prevLet = 6;
            }
            time += timeCount;
        }

        return time;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        String temp = next();
        while(!temp.equals("halt")){
            out.println(timeTaken(temp));
            temp = next();
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
