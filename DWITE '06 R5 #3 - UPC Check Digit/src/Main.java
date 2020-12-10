import java.io.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        for(int z = 0; z < 5; z++){
            String input = br.readLine();
            int even = 0;
            int odd = 0;
            for(int i = 0 ; i < input.length(); i++){
                if(i % 2 == 0){
                    odd += Character.getNumericValue(input.charAt(i));
                }
                else{
                    even += Character.getNumericValue(input.charAt(i));
                }
            }
            int other = ((even + (odd*3)+10)/10)*10;
            int base = (even+(odd*3));
            int low = ((even+(odd*3))/10)*10;
            int diffUp = other - base;
            int diffDown = low - base;
            int num = Character.getNumericValue(input.charAt(11));
            if(num + diffUp < 10){
                for(int i = 0 ; i < 11 ; i++){
                    System.out.print(input.charAt(i));
                }
                System.out.println(num + diffUp);
            }
            else{
                for(int i = 0 ; i < 11 ; i++){
                    System.out.print(input.charAt(i));
                }
                System.out.println(num +diffDown);
            }
        }



        out.close();
    }
}
