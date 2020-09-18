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
        double n = nextDouble();
        double mean = 0;
        double median = 0;//MIDDLE NUMBER IN LIST
        double mode = 0;//MODE IS THE MOST OFTEN
        int count = 0;
        double max = 0;
        double min = 1001;
        double[] arr = new double[(int)n];
        for(int i = 0 ; i < n; i++){
            double temp = nextDouble();
            mean += temp;
            if(temp > max){
                max = temp;
            }
            if(temp < min){
                min = temp;
            }
            arr[i] = temp;
        }
        Arrays.sort(arr);
        /*
        for(int i = 0 ; i < n; i++){
            System.out.println(arr[i]);
        }
        System.out.println();

         */
        if(n % 2 == 0){
            median = (arr[(int)n/2] + arr[(int)n/2-1])/2;
        }
        else{
            median = arr[(int)n/2];
        }
        double num = 0;
        int countNum = 0;
        for(int i = 0 ; i < n; i++){
            if(num == arr[i]){
                countNum++;
            }
            else{
                if(count < countNum){
                    mode = num;
                    count = countNum;
                }
                num = arr[i];
                countNum = 1;
            }
        }
        mean /= n;
        out.printf("%.2f", mean);
        out.println();
        out.printf("%.2f", median);
        out.println();
        out.printf("%.2f", mode);
        out.println();
        out.printf("%.2f", max);
        out.println();
        out.printf("%.2f", min);
        out.println();


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static double nextDouble()throws IOException{
        return Double.parseDouble(next());
    }

}
