

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<Integer[]> classes;
    static int students, classa;
    static Students[] studs;
    static ArrayList<Integer> beenTo, classBeenTo;


    static class Students{
        int num;
        ArrayList<Integer> classesIn;
        public Students(int num){
            this.num = num;
            classesIn = new ArrayList<>();
        }
        public void addClass(int num){
            classesIn.add(num);
        }
    }

    private static void addClass(int stud, int classe){
        studs[stud].addClass(classe);
    }

    private static void goThrough(int person){
        if(!beenTo.contains(person)){
            beenTo.add(person);
            for(int i = 0 ; i < studs[person].classesIn.size(); i++){
                if(!classBeenTo.contains(studs[person].classesIn.get(i))){
                    classBeenTo.add(studs[person].classesIn.get(i));
                    for(int o = 0; o < classes.get(studs[person].classesIn.get(i)).length; o++){
                        goThrough(classes.get(studs[person].classesIn.get(i))[o]);
                    }
                }

            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        students = nextInt(); classa = nextInt();
        studs = new Students[students];
        classBeenTo = new ArrayList<>();
        for(int i = 0 ; i < students; i++){
            studs[i] = new Students(i);
        }
        classes = new ArrayList<>();
        beenTo = new ArrayList<>();
        for(int i = 0 ; i < classa; i++){
            int classNum = nextInt();
            Integer[] temp = new Integer[classNum];
            for(int o = 0 ; o < classNum; o++){
                temp[o] = nextInt()-1;
            }
            classes.add(temp);
            for(int o =0 ;  o < classNum; o++){
                addClass(temp[o], i);
            }
        }
        goThrough(0);
        out.println(beenTo.size());
        Collections.sort(beenTo);
        for(int i = 0 ; i < beenTo.size(); i++){
            out.print((beenTo.get(i)+1) + " ");
        }


        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st= new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());

    }

}
