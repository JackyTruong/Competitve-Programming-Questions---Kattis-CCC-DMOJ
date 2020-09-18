import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int numMountain, numBranch, numLake;
    static ArrayList<Integer> mountain, branch, lake;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = nextInt();
        for(int z = 0 ; z < t; z++){
            int num = nextInt();
            mountain = new ArrayList<>();
            branch = new ArrayList<>();
            lake = new ArrayList<>();
            numMountain = num;
            numBranch = 0;
            numLake = 1;
            for(int i = 0 ; i < num; i++){
                mountain.add(nextInt());
            }
            boolean did = true;
            while(did && numLake < num){
                did = false;
                if(numBranch != 0){
                    if(branch.get(numBranch-1) == numLake){
                        lake.add(branch.remove(numBranch-1));
                        numLake++;
                        numBranch--;
                        did = true;
                    }
                }
                if(numMountain != 0 && !did){
                    if(mountain.get(numMountain-1) == numLake){
                        lake.add(mountain.remove(numMountain-1));
                        numMountain--;
                        numLake++;
                        did = true;
                    }
                    else{
                        branch.add(mountain.remove(numMountain-1));
                        numMountain--;
                        numBranch++;
                        did = true;
                    }
                }
            }
            if(numLake != num){
                out.println("N");
            }
            else{
                out.println("Y");
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
