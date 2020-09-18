import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int num = nextInt();
        int[] firstTime = new int[101];
        Arrays.fill(firstTime, -1);
        int[] totalTime = new int[101];
        int time = 0;
        for(int i = 0 ; i < num; i++){
            char temp = next().charAt(0);
            int tempInt = nextInt();
            if(temp == 'R'){
                firstTime[tempInt] = time;
                time++;

            }
            else if(temp == 'W'){
                time--;
                time += tempInt;
            }
            else if(temp == 'S'){
                totalTime[tempInt] += time-firstTime[tempInt];
                time++;
                firstTime[tempInt] = -1;
            }
        }
        for(int i = 1 ; i < 101; i++){
            if(firstTime[i] == -1 && totalTime[i] != 0){
                if(totalTime[i] != 0){
                    System.out.println(i + " " + totalTime[i]);
                }
                else{
                    System.out.println(i + " " + (-1));
                }
            }
            else if(firstTime[i] != -1){
                System.out.println(i + " " + -1);
            }

        }
        //System.out.println(Arrays.toString(firstTime));


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
