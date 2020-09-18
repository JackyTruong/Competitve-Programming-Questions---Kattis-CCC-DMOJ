import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[] firstNum, secondNum, subsDone;
    static int forward, spotInSub;

    private static void divide(){
        while(firstNum.length - (forward+secondNum.length) >= 0){
            if(isPossible()){
                subtract();
                subsDone[spotInSub]++;
            }
            else{
                spotInSub++;
                forward++;
            }
        }
        boolean isZero = true;
        for(int i = 0 ; i < subsDone.length;i++){
            if(isZero && subsDone[i] == 0){
            }
            else{
                System.out.print(subsDone[i]);
                isZero=false;
            }
        }
        if(isZero){
            System.out.print("0");
        }
        System.out.println("");
        int first = -1;
        for(int i = 0 ; i < firstNum.length && first == -1;i++){
            if(firstNum[i] != 0){
                first = i;
            }
        }
        if(first != -1){
            for(int i = first; i < firstNum.length; i++){
                System.out.print(firstNum[i]);
            }
        }
        else{
            System.out.println("0");
        }
        System.out.println("");
        System.out.println("");
    }

    private static void subtract(){
        for(int i = secondNum.length-1; i >= 0; i--){
            firstNum[forward+i] -= secondNum[i];
            if(firstNum[forward+i] < 0){
                firstNum[forward+i] += 10;
                firstNum[forward+i-1]-=1;
            }
        }
    }

    private static boolean isPossible(){
        boolean canDo = false;
        for(int i = 0 ; i < secondNum.length && !canDo;i++){
            if(firstNum[forward+i] < secondNum[i]){
                int temp = 1;
                while(forward-temp >= 0){
                    if(firstNum[forward-temp] > 0){
                        canDo = true;
                        break;
                    }
                    temp++;
                }
                break;
            }
            else if(firstNum[forward+i] > secondNum[i]){
                canDo = true;
            }
            if(i == secondNum.length-1 && firstNum[forward] == secondNum[i]){
                canDo = true;
            }
        }
        return canDo;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0 ; z < t; z++){
            forward = 0;
            spotInSub = 0;
            String first = next();
            String second = next();
            firstNum = new int[first.length()];
            secondNum = new int[second.length()];
            subsDone = new int[Math.abs(first.length()-second.length())+1];
            for(int i = 0 ; i < first.length(); i++){
                firstNum[i] = Character.getNumericValue(first.charAt(i));
            }
            for(int i = 0 ; i < second.length();i++){
                secondNum[i] = Character.getNumericValue(second.charAt(i));
            }
            divide();
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
