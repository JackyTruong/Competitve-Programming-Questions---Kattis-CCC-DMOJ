import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static int calcPoints(String cards){
        //out.println(cards.length() + " this is cardslength" + cards);
        int count = 0;
        for(int i = 0 ; i < cards.length();i++){
            if(cards.charAt(i) == 'A'){
                count += 4;
            }
            else if(cards.charAt(i) == 'K'){
                count += 3;
            }
            else if(cards.charAt(i) == 'Q'){
                count += 2;
            }
            else if(cards.charAt(i) == 'J'){
                count += 1;
            }
        }
        if(cards.length() == 1){
            count += 2;
        }
        else if(cards.length() == 2){
            count += 1;
        }
        return count;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        String i = next();
        out.println("Cards Dealt           Points");
        String C = i.substring(1, i.indexOf('D'));
        String D = i.substring(i.indexOf('D')+1, i.indexOf('H'));
        String H = i.substring(i.indexOf('H')+1, i.indexOf('S'));
        String S = i.substring(i.indexOf('S')+1);

        int Cc = calcPoints(C);
        int Dc = calcPoints(D);
        int Hc = calcPoints(H);
        int Sc = calcPoints(S);
        if(C.isEmpty()){
            Cc += 3;
        }
        if(D.isEmpty()){
            Dc += 3;
        }
        if(H.isEmpty()){
            Hc += 3;
        }
        if(S.isEmpty()){
            Sc += 3;
        }
        int total = Cc + Dc + Hc + Sc;
        out.print("Clubs ");
        for(int o = 0 ; o < C.length();o++){
            out.print(C.charAt(o) + " ");
        }
        for(int o = 0; o < 21-C.length()*2;o++){
            out.print(" ");
        }
        out.println(Cc);
        out.print("Diamonds ");
        for(int o = 0 ; o < D.length();o++){
            out.print(D.charAt(o) + " ");
        }
        for(int o = 0; o < 18-D.length()*2;o++){
            out.print(" ");
        }
        out.println(Dc);
        out.print("Hearts ");
        for(int o = 0 ; o < H.length();o++){
            out.print(H.charAt(o) + " ");
        }
        for(int o = 0; o < 20-H.length()*2;o++){
            out.print(" ");
        }
        out.println(Hc);
        out.print("Spades ");
        for(int o = 0 ; o < S.length();o++){
            out.print(S.charAt(o) + " ");
        }
        for(int o = 0; o < 20-S.length()*2;o++){
            out.print(" ");
        }
        out.println(Sc);
        out.print("                    Total " + total);

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}
