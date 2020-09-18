import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static String bigNum, Original;
    static int[] numA;

    private static void lowerNum(){
        minusNum(numA[numA.length-1]);
        bigNum = "";
        for(int i = 0 ;  i < numA.length-1; i++){
            if(numA[i] != -1){
                bigNum+= numA[i];
            }
        }
        numA = new int[bigNum.length()];
        for(int a = 0 ; a < bigNum.length(); a++){
            numA[a] = Character.getNumericValue(bigNum.charAt(a));
        }
        out.println(bigNum);
    }

    private static void minusNum(int n){
        int end = numA.length-2;
        numA[end] -= n;
        for(int i = end; i >= 0; i--){
            if(numA[i] < 0){
                numA[i] += 10;
                numA[i-1]--;
            }
        }
        boolean isZero = true;
        for(int i = 0 ; i < end && isZero; i++){
            if(numA[i] != 0){
                isZero = false;
            }
            else{
                numA[i] = -1;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int num = nextInt();
        for(int i = 0 ; i < num; i++){
            bigNum = next();
            Original = bigNum;
            numA = new int[bigNum.length()];
            out.println(bigNum);
            for(int a = 0 ; a < bigNum.length(); a++){
                numA[a] = Character.getNumericValue(bigNum.charAt(a));
            }
            while(bigNum.length() > 2){
                lowerNum();
            }
            int endNum = Integer.parseInt(bigNum);
            if(endNum % 11 == 0){
                out.println("The number " + Original + " is divisible by 11.");
            }
            else{
                out.println("The number " + Original + " is not divisible by 11.");
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
    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
