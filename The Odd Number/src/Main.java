import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Integer, Integer> hashmap;
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    private static int findNum(Integer num){
        if(!hashmap.containsKey(num)){
            hashmap.put(num, hashmap.size());
        }
        return hashmap.get(num);
    }

    private static int findOriginal(Integer num){
        for(Map.Entry<Integer, Integer> entry : hashmap.entrySet()){
            if(num.equals(entry.getValue())){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        hashmap = new HashMap<>();
        int n = nextInt();
        int[] arr = new int[1000000];
        for(int i = 0 ; i <n; i++){
            int num = nextInt();
            int spot = findNum(num);
            arr[spot]++;
        }
        for(int i = 0; i < 1000000; i++){
            if(arr[i] % 2 == 1){
                out.println(findOriginal(i));
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

}
