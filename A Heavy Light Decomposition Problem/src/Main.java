
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static boolean[] path;
    static Node[] arr;
    static boolean found;
    static int end, start;

    static class Node{
        int num;
        ArrayList<Integer> cons;
        public Node(int num){
            this.num = num;
            cons = new ArrayList<>();
        }
        public void addCon(int con){
            cons.add(con);
        }
    }

    private static void findPath(boolean[] beenTo, int node){
        if(!found){
            if(node == end){
                beenTo[node] = true;
                path = beenTo;
                found = true;
            }
            else if(!beenTo[node]){
                beenTo[node] = true;
                for(int i = 0 ; i < arr[node].cons.size();i++){
                    findPath(beenTo, arr[node].cons.get(i));
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();int q = nextInt();
        arr = new Node[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Node(nextInt());
        }
        for(int i = 0 ;i < n-1; i++){
            int first = nextInt()-1;
            int second = nextInt()-1;
            arr[first].addCon(second);
            arr[second].addCon(first);
        }
        for(int i = 0 ; i < q; i++){
            path = new boolean[n];
            found = false;
            int whichQ = nextInt();
            start = nextInt()-1; end = nextInt()-1;
            findPath(new boolean[n], start);
            ArrayList<Integer> nums = new ArrayList<>();
            for(int o = 0 ; o < n; o++){
                if(path[o]){
                    nums.add(arr[o].num);
                }
            }
            //TODO FIND WHICH ONE IS WRONG
            if(whichQ == 1){
                double count = 0;
                for(int o = 0 ; o < nums.size(); o++){
                    count+=nums.get(o);
                }
                count = Math.round(count/nums.size());
                out.println((int)count);
            }
            else if(whichQ == 2){
                double count = 0;
                Collections.sort(nums);
                if(nums.size() % 2 ==0){
                    count += nums.get(nums.size()/2);
                    count += nums.get(nums.size()/2-1);
                    count = Math.round(count/2.0);
                    out.println((int)count);
                }
                else {
                    out.println(nums.get(nums.size()/2));
                }
            }
            else{
                int[] counter = new int[100000];
                for(int o = 0 ; o < nums.size(); o++){
                    //System.out.println(nums.get(o) + " thispath");
                    counter[nums.get(o)]++;
                }
                int spot = 0;
                for(int o = 1 ; o < 100000; o++){
                    //System.out.println(counter[o]);
                    if(counter[o] > counter[spot]){
                        spot = o;
                    }
                }
                out.println(spot);
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
