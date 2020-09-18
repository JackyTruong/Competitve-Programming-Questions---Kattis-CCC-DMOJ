import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    static class Phone{
        String name;
        int pNum, called;
        public Phone(String name, int pNum){
            this.name = name;
            this.pNum = pNum;
        }
        public void addCalled(){
            this.called++;
        }

    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int num = nextInt();
        Phone[] numbers = new Phone[num];
        for(int i = 0 ; i < num; i++){
            numbers[i] = new Phone(next(), nextInt());
        }
        int calls = nextInt();
        for(int i = 0 ; i < calls; i++){
            int temp = nextInt();
            for(int o = 0 ; o < num; o++){
                if(numbers[o].pNum == temp){
                    numbers[o].addCalled();
                }
            }
        }
        int highest = 0;
        int index = 0;
        for(int i = 0 ; i < num; i++){
            if(numbers[i].called > highest){
                highest = numbers[i].called;
                index = i;
            }
            else if(numbers[i].called == highest){
                if(numbers[i].pNum < numbers[index].pNum){
                    index = i;
                }
            }
        }
        out.println(numbers[index].name);

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
