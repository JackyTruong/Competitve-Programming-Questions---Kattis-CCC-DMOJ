import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<Integer>[] weird;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        weird = new ArrayList[10];
        for(int i = 0 ; i < 10; i++){
            weird[i] = new ArrayList<>();
        }
        int n = Integer.parseInt(next());
        for(int i = 0 ; i < n; i++){
            String temp = next();
            if(temp.charAt(temp.length()-1) == '0'){
                weird[0].add(Integer.parseInt(temp));
            }
            else if(temp.charAt(temp.length()-1) == '1'){
                weird[1].add(Integer.parseInt(temp));
            }
            else if(temp.charAt(temp.length()-1) == '2'){
                weird[2].add(Integer.parseInt(temp));
            }
            else if(temp.charAt(temp.length()-1) == '3'){
                weird[3].add(Integer.parseInt(temp));
            }
            else if(temp.charAt(temp.length()-1) == '4'){
                weird[4].add(Integer.parseInt(temp));
            }
            else if(temp.charAt(temp.length()-1) == '5'){
                weird[5].add(Integer.parseInt(temp));
            }
            else if(temp.charAt(temp.length()-1) == '6'){
                weird[6].add(Integer.parseInt(temp));
            }
            else if(temp.charAt(temp.length()-1) == '7'){
                weird[7].add(Integer.parseInt(temp));
            }
            else if(temp.charAt(temp.length()-1) == '8'){
                weird[8].add(Integer.parseInt(temp));
            }
            else if(temp.charAt(temp.length()-1) == '9'){
                weird[9].add(Integer.parseInt(temp));
            }
        }
        for(int i = 0 ;  i < 10; i++){
            Collections.sort(weird[i], Collections.reverseOrder());
        }
        for(int i = 0 ; i < 10; i++){
            for(int o = 0 ; o < weird[i].size();o++){
                out.print(weird[i].get(o) + " ");
            }
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

}
