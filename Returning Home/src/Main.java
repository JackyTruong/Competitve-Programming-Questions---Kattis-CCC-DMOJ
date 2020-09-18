import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        ArrayList<Character> direction = new ArrayList<>();
        ArrayList<String> street = new ArrayList<>();
        String d = next();
        String streetTemp =  next();
        while(!streetTemp.equals("SCHOOL")){
            direction.add(d.charAt(0));
            street.add(streetTemp);
            d = next();
            streetTemp = next();
        }
        direction.add(d.charAt(0));
        street.add(streetTemp);
        int o = 0;
        for(int i = street.size()-1 ;i >= 0; i--){
            if(i != 0){
                if(direction.get(i) == 'L'){
                    out.print("Turn RIGHT onto ");
                }
                else{
                    out.print("Turn LEFT onto ");
                }
                out.println(street.get(i-1) + " street.");
            }
            else{
                if(direction.get(0) == 'L'){
                    out.print("Turn RIGHT into your HOME.");
                }
                else{
                    out.print("Turn LEFT into your HOME.");
                }
            }

            o++;
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
