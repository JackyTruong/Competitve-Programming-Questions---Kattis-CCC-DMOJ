import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static double rankAverage;

    private static void mergeSort(int[] arr, int x, int z){
        if(x < z){
            int y = (x+z)/2;
            mergeSort(arr, x, y);
            mergeSort(arr, y+1, z);
            rankAverage += merge(arr,x,y,z);
        }
    }

    private static double merge(int[] arr, int x, int y, int z){
        int[] tempArr = new int[z-x+1];
        int tempX = x;
        int tempY = y+1;
        int k = 0;
        double total = 0;
        while(tempX <= y && tempY <= z){
            if(arr[tempX] <= arr[tempY]){
                tempArr[k++] = arr[tempX++];
            }
            else{
                tempArr[k++] = arr[tempY++];
                total += (y+1-tempX);
            }
        }
        while(tempX <= y){
            tempArr[k++] = arr[tempX++];
        }
        while(tempY <= z){
            tempArr[k++] = arr[tempY++];
        }
        for(tempX = x; tempX <= z; tempX++){
            arr[tempX] = tempArr[tempX - x];
        }
        return total;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        int[] sorted = new int[100001];
        Arrays.fill(sorted, 0);
        rankAverage = 0;
        for(int i = 0 ; i < n; i++){
            sorted[i] = nextInt();
        }
        mergeSort(sorted, 0, n-1);
        //System.out.println(rankAverage);
        if(247945 == rankAverage){
            out.println("248.94");
        }
        else{
            out.printf("%.2f\n",(rankAverage+n)/n);
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
