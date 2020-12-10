import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++){
            boolean couldSet = true;
            boolean couldRare = true;
            boolean couldMagic = true;
            StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
            int words = temp.countTokens();
            String[] name = new String[words];
            for(int o = 0 ; o < words; o++){
                name[o] = temp.nextToken();
            }
            char tempSpot = (char)39;
            if(name[0].length() >= 2){
                if(name[0].charAt(name[0].length()-1) != 's' && name[0].charAt(name[0].length()-2) != tempSpot || words < 2){
                    couldSet = false;
                }else{
                    couldMagic = false;
                    couldRare = false;
                }
            }
            else{
                couldSet = false;
            }

            if(name[0].equals("Damaged")){
                couldMagic = false;
                couldRare = false;
                couldSet = false;
            }

            if(words != 2){
                couldRare = false;
                if(words == 3){
                    if(!name[1].equals("of")){
                        couldMagic = false;
                    }
                }
                else if(words == 4){
                    if(!name[2].equals("of")){
                        couldMagic = false;
                    }
                }
                else{
                    couldMagic = false;
                }
            }


            if((couldMagic && couldRare)){
                out.println("Not sure, take anyways");
            }
            else if(couldMagic){
                out.println("Magic");
            }
            else if(couldRare){
                out.println("Rare");
            }
            else if(couldSet){
                out.println("Set");
            }
            else{
                out.println("Normal");
            }
        }

        out.close();
    }

}
