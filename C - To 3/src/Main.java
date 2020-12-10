import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<String> beenTo;
    static int length, numlen;

    private static void removeNums(String nums){
        //System.out.println("this is nums " + nums );
        if(!beenTo.contains(nums)){
            beenTo.add(nums);
            int total = 0;
            for(int i = 0 ; i < nums.length(); i++){
                total += Character.getNumericValue(nums.charAt(i));
            }
            if(total % 3 == 0 && total != 0){
                if(nums.length() > length){
                    length = nums.length();
                }
            }
            else if(total == 0 && length == 0){
                length = -1;
            }
            else{
                for(int i = 0 ; i < nums.length();i++){
                    String temp = "";
                    for(int o = 0 ; o < nums.length(); o++){
                        if(i != o){
                            temp += nums.charAt(o);
                        }
                    }
                    removeNums(temp);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        beenTo = new ArrayList<>();
        String num = next();
        length = 0;
        long total = 0;
        numlen = num.length();
        for(int i = 0 ; i < numlen; i++){
            total += Character.getNumericValue(num.charAt(i));
        }
        if(total % 3 == 0){
            out.println(0);
        }
        else{
            removeNums(num);
            if(length != -1){
                out.println(numlen-length);
            }
            else{
                out.println(length);
            }

        }

        out.close();
    }

    private static String next()throws IOException {
        while(st==null||!st.hasMoreTokens()){
            st= new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }

}
