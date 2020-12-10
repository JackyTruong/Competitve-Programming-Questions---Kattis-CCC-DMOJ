import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int n, counting;
    static ArrayList<int[]> found;

    private static void findMajor(int[] arr){
        boolean here = false;
        for(int i = 0 ; i < found.size(); i++){
            if(Arrays.toString(found.get(i)).equals(Arrays.toString(arr))){
                here = true;
            }
        }
        if(!here){
            found.add(arr);
            int[] count = new int[n+1];
            for(int i = 0 ; i < arr.length; i++){
                count[arr[i]]++;
            }
            int highest = 0;
            boolean singular = true;
            for(int i = 0 ; i < n; i++){
                if(count[i] > count[highest]){
                    highest = i;
                    singular = true;
                }
                else if(count[i] == count[highest] && i != highest){
                    singular = false;
                }
            }
            if(singular && count[highest] > arr.length/2){
                //System.out.println(Arrays.toString(arr));
                counting++;
            }
            if(arr.length > 2){
                findMajor(Arrays.copyOfRange(arr, 0, arr.length-1));
                findMajor(Arrays.copyOfRange(arr, 1, arr.length));
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        found = new ArrayList<>();
        counting = 0;
        int[] arr =new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = nextInt();
        }
        findMajor(Arrays.copyOfRange(arr, 0, arr.length-1));
        findMajor(Arrays.copyOfRange(arr, 1, arr.length));
        counting+=n;
        out.println(counting);

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
