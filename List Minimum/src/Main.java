import java.io.*;
import java.util.ArrayList;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> temp  =new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            temp.add(Integer.parseInt(br.readLine()));
        }
        while(!temp.isEmpty()){
            int smallest = Integer.MAX_VALUE;
            int spot = 0;
            for(int i = 0 ; i < temp.size();i++){
                if(temp.get(i) < smallest){
                    smallest = temp.get(i);
                    spot = i;
                }
            }
            out.println(temp.get(spot));
            temp.remove(spot);
        }



        out.close();
    }
}
