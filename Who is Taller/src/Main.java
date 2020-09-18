import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<cHeight> students;
    static boolean answerTaller, answerShorter;
    static boolean[] beenTo;

    static class cHeight{
        int student;
        ArrayList<Integer> taller, shorter;
        public cHeight(int student){
            this.student = student;
            this.taller = new ArrayList<>();
            this.shorter = new ArrayList<>();
        }
        public void addTaller(int student){
            this.taller.add(student);
        }
        public void addShorter(int student){
            this.shorter.add(student);
        }
    }

    private static int findIndex(int student){
        for(int i = 0 ; i < students.size(); i++){
            if(students.get(i).student == student){
                return i;
            }
        }
        return -1;
    }

    private static void isTaller(int taller, int spot){
        if(!answerTaller){
            beenTo[spot] = true;
            int temp = findIndex(spot);
            if(!students.get(temp).taller.contains(taller)){
                for(int i = 0 ; i < students.get(temp).taller.size();i++){
                    if(!beenTo[students.get(temp).taller.get(i)]){
                        isTaller(taller, students.get(temp).taller.get(i));
                    }
                }
            }
            else if(students.get(temp).taller.isEmpty()){
                return;
            }
            else{
                answerTaller = true;
            }
        }
    }

    private static void isShorter(int spot, int shorter){
        if(!answerShorter){
            beenTo[spot] = true;
            int temp = findIndex(spot);
            if(!students.get(temp).shorter.contains(shorter)){
                for(int i = 0 ; i < students.get(temp).shorter.size();i++){
                    if(!beenTo[students.get(temp).shorter.get(i)]){
                        isShorter(students.get(temp).shorter.get(i),shorter);
                    }
                }
            }
            else if(students.get(temp).shorter.isEmpty()){
                return;
            }
            else{
                answerShorter = true;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int numStudents = nextInt();
        int known = nextInt();
        students = new ArrayList<>();
        answerTaller = false;
        answerShorter = false;
        for(int i = 0 ; i <= numStudents;i++){
            students.add(new cHeight(i));
        }
        beenTo = new boolean[numStudents+1];
        for(int i = 0; i < known; i++){
            int taller = nextInt();
            int shorter = nextInt();
            students.get(taller).addShorter(shorter);
            students.get(shorter).addTaller(taller);
        }

        int tallerNum = nextInt();
        int shorterNum = nextInt();
        isTaller(tallerNum, shorterNum);
        if(!answerTaller){
            isShorter(shorterNum, tallerNum);
        }
        //System.out.println(answerShorter + " " + answerTaller);
        if(answerTaller && !answerShorter){
            out.println("yes");
        }
        else if(!answerTaller && answerShorter){
            out.println("no");
        }
        else if(!answerTaller){
            out.println("unknown");
        }



        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
