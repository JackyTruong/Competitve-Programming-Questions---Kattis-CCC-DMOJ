import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static boolean isAWord(String s) {
        ArrayList<Integer> spotsN = new ArrayList<>();
        spotsN.add(0);
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == 'N'){
                spotsN.add(i);
            }
        }
        boolean second = true;
        //System.out.println(s);
        if(s.length() == 0){
            second = false;
        }
        else if (s.charAt(0) == 'A') {
            for (int i = 1; i < s.length(); i++) {
                if (i % 2 == 1 && s.charAt(i) != 'N') {
                    second =  false;
                } else if (i % 2 == 0 && s.charAt(i) != 'A') {
                    second = false;
                }
            }
        }
        else if(s.charAt(0) == 'B'){
            if(s.charAt(s.length()-1) == 'S'){
                boolean temp = isAWord(s.substring(1,s.length()-1));
                if(!temp){
                    second = false;
                }
            }
            else{
                second =  false;
            }
        }
        else{
            second =  false;
        }
        boolean one = false;
        for(int i = 0 ; i < spotsN.size()-1;i++){
            for(int o = 1; o < spotsN.size(); o++){
                if(spotsN.get(i) < s.length() && spotsN.get(o) < s.length() && spotsN.get(i) < spotsN.get(o)){
                    boolean tempB = isAWord(s.substring(spotsN.get(i), spotsN.get(o)));
                    boolean tempC = isAWord(s.substring(spotsN.get(o)+1));
                    //System.out.println(s.substring(spotsN.get(i), spotsN.get(o)) + " tempB");
                    //System.out.println(s.substring(spotsN.get(o)+1) + " Temp C");
                    //System.out.println(tempB + " " + tempC +" " + s + "this is what");
                    if(tempB && tempC){
                        one = true;
                    }
                }
            }

        }
        if(second || one){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        String temp = next();
        while(!temp.equals("X")){
            boolean second = isAWord(temp);
            //System.out.println(one + " this");
            if(second){
                out.println("YES");
            }
            else{
                out.println("NO");
            }
            temp = next();
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
