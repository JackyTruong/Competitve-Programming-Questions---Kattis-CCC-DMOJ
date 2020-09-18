import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static ArrayList<Person> docs;

    static class Person{
        int num;
        ArrayList<String> docs;
        public Person(int num, String doc){
            this.num = num;
            docs = new ArrayList<>();
            docs.add(doc);
        }
        public void addDoc(String doc){
            docs.add(doc);
        }
    }

    private static int findSpot(int num){
        for(int i = 0 ; i < docs.size(); i++){
            if(docs.get(i).num == num){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        docs = new ArrayList<>();
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int rec = Integer.parseInt(st.nextToken());
            String name = br.readLine();
            int spot = findSpot(rec);
            if(spot != -1){
                docs.get(spot).addDoc(name);
            }
            else{
                Person temp = new Person(rec, name);
                docs.add(temp);
            }

        }
        int person = Integer.parseInt(br.readLine());
        int spot = findSpot(person);
        if(spot != -1){
            for(int i = 0; i < docs.get(spot).docs.size(); i++){
                out.println(docs.get(spot).docs.get(i));
            }
        }

        out.close();
    }

}
