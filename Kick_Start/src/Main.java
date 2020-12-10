import java.io.*;
        import java.util.ArrayList;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine().trim());
        for(int z=  0 ;z < n; z++){
            String input = br.readLine();
            ArrayList<Integer> start = new ArrayList<>();
            int count = 0;
            ArrayList<Integer> kick = new ArrayList<>();
            for(int i = 0 ; i < input.length(); i++){
                if(i+4 < input.length() && input.charAt(i) == 'S' && input.charAt(i+1) == 'T' && input.charAt(i+2) == 'A' && input.charAt(i+3) == 'R' && input.charAt(i+4) == 'T'){
                    start.add(i);
                }
                if(i+3 < input.length() && input.charAt(i) == 'K' && input.charAt(i+1) =='I' && input.charAt(i+2) == 'C' && input.charAt(i+3) == 'K'){
                    kick.add(i+4);
                }
            }
            for(int i = 0 ; i < kick.size(); i++){
                for(int o = 0; o < start.size(); o++){
                    if(start.get(o) >= kick.get(i)){
                        count++;
                    }
                }
            }
            out.println("Case #" + (z+1) + ": " + count);

        }


        out.close();
    }
}
