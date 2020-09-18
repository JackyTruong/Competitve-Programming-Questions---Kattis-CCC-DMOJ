import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static ArrayList<Integer> ids;

    private static boolean stackable(){
        ArrayList<Integer> top = new ArrayList<>();
        ArrayList<Integer> bot = new ArrayList<>();
        boolean canMove = true;
        ArrayList<Integer> temp2 = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0 ; i < ids.size(); i++){
            temp.add(ids.get(i));
            temp2.add(ids.get(i));
        }
        //System.out.println(temp.size());
        top.add(temp.remove(0));
        while(!temp.isEmpty() && canMove){
            boolean did = false;
            //System.out.println(temp.get(0) + " " + top.get(0));
            if(temp.get(0) == top.get(0)-1){
                top.add(0, temp.remove(0));
                did = true;
            }
            else if(temp.get(0) == top.get(top.size()-1)+1){
                top.add(temp.remove(0));
                did = true;
            }
            //System.out.println(temp.get(temp.size()-1) + " " + top.get(top.size()-1));
            if(temp.size()-1 >= 0 && temp.get(temp.size()-1) == top.get(top.size()-1)+1){
                top.add(temp.remove(temp.size()-1));
                did = true;
            }
            else if(temp.size()-1 >= 0 && temp.get(temp.size()-1) == top.get(0)-1){
                top.add(0,temp.remove(temp.size()-1));
                did = true;
            }
            if(!did){
                canMove = false;
            }
        }
        boolean canMove2 = true;
        //System.out.println(ids.size());
        bot.add(temp2.remove(temp2.size()-1));
        while(!temp2.isEmpty() && canMove2){
            boolean did = false;
            //System.out.println(temp.get(0) + " " + top.get(0));
            if(temp2.get(0) == bot.get(0)-1){
                bot.add(0, temp2.remove(0));
                did = true;
            }
            else if(temp2.get(0) == bot.get(bot.size()-1)+1){
                bot.add(temp2.remove(0));
                did = true;
            }
            //System.out.println(temp.get(temp.size()-1) + " " + top.get(top.size()-1));
            if(temp2.size()-1 >= 0 && temp2.get(temp2.size()-1) == bot.get(bot.size()-1)+1){
                bot.add(temp2.remove(temp2.size()-1));
                did = true;
            }
            else if(temp2.size()-1 >= 0 && temp2.get(temp2.size()-1) == bot.get(0)-1){
                bot.add(0,temp2.remove(temp2.size()-1));
                did = true;
            }
            if(!did){
                canMove2 = false;
            }
        }
        if(canMove || canMove2){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int i = 0 ; i < t; i++){
            int numS = nextInt();
            ids = new ArrayList<>();
            for(int o = 0 ;o < numS; o++){
                ids.add(nextInt());
            }
            if(stackable()){
                out.println("Case #" + (i+1) + ": yes");
            }
            else{
                out.println("Case #" + (i+1) + ": no");
            }
        }

        out.close();
    }

    private static String next()throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
