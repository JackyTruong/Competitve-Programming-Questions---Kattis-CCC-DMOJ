import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static class Time{
        int start, end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        ArrayList<Time> temp = new ArrayList<>();
        int largest = 0;
        for(int i = 0 ; i < n; i++){
            int temp1 = nextInt();
            int temp2 = nextInt();
            temp.add(new Time(temp1, temp2));
            if(temp2 > largest){
                largest = temp2;
            }
        }
        int[] arr = new int[largest];
        for(int i = 0 ; i < temp.size(); i++){
            arr[temp.get(i).start-1]++;
            arr[temp.get(i).end-1]--;
        }
        int output = 0;
        int tempC = 0;
        for(int i = 0 ; i < largest; i++){
            tempC += arr[i];
            if(tempC > output){
                output = tempC;
            }
        }
        out.println(output);

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
