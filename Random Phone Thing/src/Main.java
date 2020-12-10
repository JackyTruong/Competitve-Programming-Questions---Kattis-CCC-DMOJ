import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static class Person{
        long phone;
        String name;
        public Person(long phone, String name){
            this.phone = phone;
            this.name = name;
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt(), q = nextInt();
        Person[] friends = new Person[n];
        for(int i = 0 ; i < n; i++){
            String name = next();
            long number = nextLong();
            friends[i] = new Person(number, name);
        }
        for(int i = 0 ; i < q; i++){
            String input = next();
            if(input.equals("name")){
                long num = nextLong();
                for(int o = 0 ; o < n; o++){
                    if(friends[o].phone == num){
                        out.println(friends[o].name);
                        break;
                    }
                }
            }
            else{
                String name = next();
                for(int o = 0 ; o < n; o++){
                    if(friends[o].name.equals(name)){
                        out.println(friends[o].phone);
                        break;
                    }
                }
            }
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

    private static long nextLong()throws IOException{
        return Long.parseLong(next());
    }
}
