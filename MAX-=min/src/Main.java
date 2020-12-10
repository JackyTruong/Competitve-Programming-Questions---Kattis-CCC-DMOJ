import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = nextInt();
        }
        Arrays.sort(arr);
        while(arr[0] != arr[n-1]){
            int lowest = arr[0];
            int highest = arr[n-1];
            int secondH = 0;
            for(int i = n-1; i >= 0; i--){
                if(arr[i] != highest){
                    secondH = arr[i];
                    break;
                }
            }
            //System.out.println(lowest + " " + highest + " " +secondH);
            for(int i = n-1; i >= 0; i--){
                if(highest == arr[i]){
                    int amount = (arr[i]-secondH)/lowest;
                    if(amount == 0){
                        amount++;
                    }
                    //System.out.println("this is am " + amount);
                    arr[i] -= amount*lowest;
                    //System.out.println("this arr " + arr[i]);
                }
                else{
                    break;
                }
            }
            Arrays.sort(arr);
        }
        out.println(arr[0]);


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
