import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    private static boolean isBoring(String num){
        for(int i = 0 ; i < num.length(); i++){
            if(Character.getNumericValue(num.charAt(i))%2 == 1 && i % 2 != 0){
                return false;
            }
            else if(Character.getNumericValue(num.charAt(i)) % 2 == 0 && i % 2 != 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        long t = nextLong();
        for(int z = 0 ; z < t; z++){
            long count = 0;
            long l = nextLong();
            long r = nextLong();
            String temp = Long.toString(l);
            long end = l - Character.getNumericValue(temp.charAt(temp.length()-1)) + 10;
            temp = Long.toString(r);
            long begin = r - Character.getNumericValue(temp.charAt(temp.length()-1));
            if(l + 10 <= r){
                for(long i = l; i < end; i++){
                    if(isBoring(Long.toString(i))){
                        count++;
                    }
                }
                for(long i = end; i < begin;){
                    if(isBoring(Long.toString(i))){
                        count++;
                        for(int o = 0 ; o < 4; o++){
                            i += 2;
                            count++;
                        }
                        i+=2;
                    }
                    else if(isBoring(Long.toString(i+1))){
                        i++;
                        count++;
                        for(int o = 0 ; o < 4; o++){
                            i += 2;
                            count++;
                        }
                        i++;
                    }
                    else{
                        i+=10;
                    }
                }
            }

            for(long i = begin; i <= r; i++){
                if(isBoring(Long.toString(i))){
                    count++;
                }
            }

            out.println("Case #" + (z+1) + ": " + count);
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }

}
