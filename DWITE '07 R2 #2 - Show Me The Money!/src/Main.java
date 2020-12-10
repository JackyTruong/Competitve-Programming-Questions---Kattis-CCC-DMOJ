import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int count = 0;
        for(int z = 0 ;z < 5; z++){
            boolean ohNo = false;
            String temp = br.readLine();
            for(int i = 0; i < temp.length(); i++){
                if(temp.charAt(i) == '+'){
                    count++;
                }
                else{
                    count--;
                }
                if(count < 0){
                    count = 0;
                    ohNo = true;
                    break;
                }
            }
            if(!ohNo){
                out.println(count);
            }
            else{
                out.println("OH NOES!");
            }

        }




        out.close();
    }
}
