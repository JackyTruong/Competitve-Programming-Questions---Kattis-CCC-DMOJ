import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[] arr;
    static int n;
    static ArrayList<Integer> cycleLen;
    static boolean[] spots;
    static ArrayList<Integer> path;

    //TODO DETECT CYCLE THEN FIND LCM OF CYCLES

    private static boolean findCycle(int i, boolean[] beenTo, boolean[]stack){
        spots[i] = true;
        path.add(i);
        if(stack[i]){
            return true;
        }
        if(beenTo[i]){
            return false;
        }
        beenTo[i] = true;
        stack[i] = true;

        if(findCycle(arr[i], beenTo, stack)){
            return true;
        }
        stack[i] = false;
        return false;
    }

    private static void detectCycle(){
        boolean[] beenTo = new boolean[n];
        boolean[] stack = new boolean[n];
        //System.out.println("here " + n);
        for(int i = 0 ; i < n; i++){
            if(!spots[i]){
                //spots[i] = true;
                path = new ArrayList<>();
                //System.out.println();
                if(findCycle(i, beenTo, stack)){
                    /*
                    for(int o = 0 ; o < path.size(); o++){
                        System.out.println(path.get(o));
                    }
                    System.out.println();

                     */
                    cycleLen.add(path.size()-1);
                }
            }

        }
    }

    private static int lcm(){
        int lcm = 1;
        int div = 2;
        while(true){
            int count = 0;
            boolean did = false;
            for(int i = 0 ; i < cycleLen.size(); i++){
                if(cycleLen.get(i) == 1){
                    count++;
                }
                if(cycleLen.get(i) % div == 0){
                    did = true;
                    cycleLen.set(i, cycleLen.get(i)/div);
                }
            }
            if(did){
                lcm = lcm*div;
            }
            else{
                div++;
            }
            if(count == cycleLen.size()){
                return lcm;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        n = nextInt();
        while(n != 0){
            arr = new int[n];
            spots = new boolean[n];
            cycleLen = new ArrayList<>();
            for(int i = 0 ; i < n; i++){
                int from = nextInt()-1;
                int to = nextInt()-1;
                arr[from] = to;
            }

            detectCycle();
            /*
            for(int i = 0 ; i < cycleLen.size(); i++){
                System.out.println(cycleLen.get(i));
            }
            System.out.println();

             */
            out.println(lcm());
            n = nextInt();
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
