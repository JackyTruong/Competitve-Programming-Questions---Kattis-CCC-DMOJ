import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static long[] arr, potato;


    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int r = nextInt(), c = nextInt();long K = Long.parseLong(next());
        arr = new long[r+1];potato = new long[r+1];
        if(K == 0){
            out.println(0);
        }
        else{
            int w = 0;
            boolean done = false;
            for(int i = 0 ; i < c;i++){
                int front = nextInt()-1;
                int back = nextInt()-1;
                arr[front]--;
                arr[back+1]++;
            }
            int temp = 0;
            long total = 0;
            long[] pref = new long[r];
            for(int i = 0; i < r && !done; i++) {
                temp += arr[i];
                total += temp+c;
                potato[i] = temp+c;
                if(i == 0){
                    pref[i] = potato[i];
                }
                else{
                    pref[i] = pref[i-1] + potato[i];
                }
                if(potato[i] == K){
                    w = 1;
                    done = true;
                }
                //System.out.print(potato[i] + " ");
            }
            //System.out.println();
            if(total > K){
                int a = 2;
                while(!done){
                    for(int i = 0 ; i <= r-a && !done; i++){
                        if(i == 0){
                            if(pref[i+a-1] >= K){
                                w = a;
                                done = true;
                            }
                        }
                        else{
                            if(pref[i+a-1]-pref[i-1] >= K){
                                //System.out.println(pref[i+a-1] + " " + (i-1));
                                w = a;
                                done = true;
                            }
                        }
                    }
                    a++;
                }
            }
            else if(total == K){
                w = c;
            }
            else{
                w = -1;
            }
            out.println(w);
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
