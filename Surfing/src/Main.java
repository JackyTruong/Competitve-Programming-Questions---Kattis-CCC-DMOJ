import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static int whichNum(String[] websites, String looking){
        int spot = -1;
        for(int i = 0; i < websites.length;i++){
            if(websites[i].equals(looking)){
                spot = i;
            }
            }
        return spot;
    }

    private static boolean surf(ArrayList[] goTo, String from, String to, boolean[] beenTo, String[] websites, int spot){
        boolean canGo = false;
        //System.out.println("this is the spot " + from + " " + to);
        if(from.equals(to)){
            canGo = true;
        }

        beenTo[spot] = true;
        for(int i = 0 ; i < goTo[spot].size();i++){
            //System.out.println("these are the sites " + goTo[spot].get(i));
            if(goTo[spot].get(i).equals(to)){
                canGo = true;
            }
           // System.out.println("this is beenTo " + beenTo[whichNum(websites,(String)goTo[spot].get(i))]);
        }
        for(int i = 0 ; i < goTo[spot].size();i++){
            int temp = whichNum(websites, (String)goTo[spot].get(i));
            if(temp != -1 && !beenTo[whichNum(websites,(String)goTo[spot].get(i))] && surf(goTo, (String)goTo[spot].get(i), to, beenTo, websites, temp)){
                canGo = true;
            }
            // System.out.println("this is beenTo " + beenTo[whichNum(websites,(String)goTo[spot].get(i))]);
        }

        return canGo;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        String[] websites = new String[n];
        ArrayList[] goTo = new ArrayList[n];


        //TODO make an array telling u which website goes to what other sites ALREADY PUT DOWN THE FOUNDATION FOR THE SITE LINKS VVV
        //TODO u might wanna use an arraylist for the sites it links to and a array for the their actual site addresses
        //TODO also to search u probably needa do recursion throughout the links each one connects to
        //TODO probably like a if(ThisSite || OtherSite){ return true;}
        //TODO ALL DONE
        for(int i = 0; i < n; i++){
            ArrayList<String> towards = new ArrayList<>();
            websites[i] = next();
            String temp = next();
            while(!temp.equals("</HTML>")){
                if(temp.length() >= 2 && temp.charAt(0) == 'H' && temp.charAt(1) == 'R' && temp.charAt(2) == 'E' && temp.charAt(3) == 'F'){
                    int spot = 0;
                    for(int o = 7; o < temp.length();o++){
                        if(temp.charAt(o) == '"'){
                            spot = o;
                        }
                    }
                    String link = temp.substring(6, spot);
                    //System.out.println(link);
                    towards.add(link);
                }
                temp = next();
            }
            goTo[i] = towards;
        }

        for(int i = 0; i < goTo.length;i++){
            for(int o = 0; o < goTo[i].size();o++){
                out.println("Link from " + websites[i] + " to " + goTo[i].get(o));
            }
        }
        String temp = next();
        while(!temp.equals("The")){
            String secondWeb = next();
            boolean[] beenTo = new boolean[n];
            Arrays.fill(beenTo, false);
            //System.out.println("can it go" +surf(goTo, temp, secondWeb, beenTo, websites) );
            int spot = whichNum(websites, temp);
            if(spot != -1 && surf(goTo, temp, secondWeb, beenTo, websites, spot)){
                out.println("Can surf from " + temp + " to " + secondWeb + ".");
            }
            else{
                out.println("Can't surf from " + temp + " to " + secondWeb + ".");
            }
           // System.out.println(Arrays.toString(beenTo));
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

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }
}
