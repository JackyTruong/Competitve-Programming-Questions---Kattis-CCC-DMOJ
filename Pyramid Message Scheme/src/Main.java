import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static ArrayList<info> people;
    static ArrayList<String> beenTo;

    static class info{
        String name;
        ArrayList<String> interact;
        public info(String name){
            this.name = name;
            this.interact = new ArrayList<>();
        }
    }

    private static int inPeople(String name){
        for(int i = 0 ; i < people.size();i++){
            if(people.get(i).name.equals(name)){
                return i;
            }
        }
        return -1;
    }

    private static int findLongest(String name, int count){
        int tempCount = 0;
        //System.out.println("this is the name " + name + " " + count);
        int spot = inPeople(name);
        beenTo.add(name);
        for(int i = 0 ; i < people.get(spot).interact.size();i++){
            int temp = 0;
            if(!beenTo.contains(people.get(spot).interact.get(i))){
                temp = findLongest(people.get(spot).interact.get(i), count+1);
            }
            if(temp > tempCount){
                tempCount = temp;
            }
        }
        if(tempCount > count){
            count = tempCount;
        }
        return count;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        for(int a = 0 ; a < n; a++){
            int p = nextInt();
            people = new ArrayList<>();
            beenTo = new ArrayList<>();
            ArrayList<String> tempNames = new ArrayList<>();
            for(int i = 0 ; i < p; i++){
                tempNames.add(next());
            }
            for(int i = 0 ; i < tempNames.size();i++){
                int temp = inPeople(tempNames.get(i));
                if(temp != -1 && i % 2 == 0){
                    people.get(temp).interact.add(tempNames.get(i+1));
                }
                else if(temp != -1){
                    people.get(temp).interact.add(tempNames.get(i-1));
                }
                else{
                    info tempInfo = new info(tempNames.get(i));
                    if(i % 2 == 0){
                        tempInfo.interact.add(tempNames.get(i+1));
                    }
                    else{
                        tempInfo.interact.add(tempNames.get(i-1));
                    }
                    people.add(tempInfo);
                }
            }
/*
        for(int i = 0 ; i < people.size();i++) {
            System.out.print(people.get(i).name + " ");
            for (int o = 0; o < people.get(i).interact.size(); o++) {
                System.out.println("rest of names " + people.get(i).interact.get(o));
            }
        }

 */
            int longest = findLongest(tempNames.get(p-1), 0);
            //out.println(longest);
            int output = (p-(longest*2))*10;
            out.println(output);
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
