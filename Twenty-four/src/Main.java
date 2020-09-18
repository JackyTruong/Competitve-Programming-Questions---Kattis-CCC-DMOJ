import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int[] nums;
    static int highest;

    private static int combinations(int[] nums, int handSize, int[][] newNums, int o){
        for(int i = 0 ; i < handSize; i++){
            for(int a = 0 ; a < handSize; a++){
                if(i != a){
                    newNums[o][0] = nums[i] + nums[a];
                    int b = 1;
                    for(int c = 0; c < handSize; c++){
                        if(!(c == i || c == a)){
                            newNums[o][b++] = nums[c];
                        }
                    }
                    o++;

                    newNums[o][0] = nums[i]-nums[a];
                    b = 1;
                    for(int c = 0 ; c < handSize; c++){
                        if(!(c == i || c == a)){
                            newNums[o][b++] = nums[c];
                        }
                    }
                    o++;
                    newNums[o][0] = nums[i] * nums[a];
                    b = 1;
                    for(int c = 0; c < handSize; c++){
                        if(!(c == i || c == a)){
                            newNums[o][b++] = nums[c];
                        }
                    }
                    o++;
                    if(nums[a] != 0 && nums[i]%nums[a] == 0){
                        newNums[o][0] = nums[i]/nums[a];
                        b = 1;
                        for(int c = 0 ; c < handSize; c++){
                            if(!(c == i || c == a)){
                                newNums[o][b++] = nums[c];
                            }
                        }
                        o++;
                    }

                }
            }
        }
        return o;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        for(int i = 0 ; i < n; i++){
            int[][] nums = new int[1][4];
            int[][] newNums;
            int prevSize;
            for(int o = 0 ; o < 4; o++){
                nums[0][o] = nextInt();
            }
            int newNumSize = 1;
            for(int o = 4; o > 1; o--){
                prevSize = newNumSize;
                newNums = nums;
                nums = new int[10000][3];
                newNumSize = 0;
                for(int a = 0 ; a < prevSize; a++){
                    newNumSize = combinations(newNums[a], o, nums, newNumSize);
                }
            }
            prevSize = newNumSize;
            int largest = 0;
            for(int o = 0 ; o < prevSize && largest < 24; o++){
                if(nums[o][0] > largest && nums[o][0] <= 24){
                    largest = nums[o][0];
                }
            }
            out.println(largest);
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
