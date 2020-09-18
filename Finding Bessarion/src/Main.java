import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        boolean isVal = false;
        String[] temp = new String[n];
        int spot = 0;
        for(int i = 0 ; i < n; i++){
            temp[i] = br.readLine();
            if(temp[i].equals("Bessarion")){
                spot = i;
            }
        }
        if(spot == 0){
            if((temp[n-1].equals("Leslie") || temp[n-1].equals("Bayview")) && (temp[1].equals("Leslie") || temp[1].equals("Bayview"))){
                isVal = true;
            }
        }
        else if(spot == n-1){
            if((temp[0].equals("Leslie") || temp[0].equals("Bayview") && (temp[n-2].equals("Leslie") || temp[n-2].equals("Bayview")))){
                isVal= true;
                System.out.println("here");
            }
        }
        else{
            if((temp[spot+1].equals("Leslie") || temp[spot+1].equals("Bayview") && (temp[spot-1].equals("Leslie") || temp[spot-1].equals("Bayview")))){
                isVal = true;
            }
        }

        if(isVal){
            out.println("Y");
        }
        else{
            out.println("N");
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
