import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int[] have = new int[8];
        int[] people = new int[8];
        int[] diff = new int[8];
        int treat = 0;
        for(int i = 0; i < 8; i++){
            have[i] = nextInt();
        }
        for(int i = 0 ; i < 8 ; i++){
            people[i] = nextInt();
        }
        for(int i = 0 ; i < 8; i++){
            diff[i] = have[i]-people[i];
            if(diff[i] >= 0){
                treat += people[i];

            }
            else{
                treat += have[i];
            }
        }
        if(diff[0] > 0 && diff[1] < 0){
            if(diff[0] >= Math.abs(diff[1])){
                diff[0] -= Math.abs(diff[1]);
                treat += Math.abs(diff[1]);
                diff[1] = 0;
            }
            else{
                diff[1] += diff[0];
                treat += diff[0];
                diff[0] = 0;

            }
        }
        for(int i = 2 ; i < 8; i+=2){
            //System.out.println(treat);
            if(diff[i] < 0){
                //System.out.println(treat);
                if(i == 2){
                    if(diff[0] > 0){
                        if(diff[0] >= Math.abs(diff[i])){
                            diff[0] -= Math.abs(diff[i]);
                            treat += Math.abs(diff[i]);
                            diff[i] = 0;
                            //System.out.println("here" + treat);
                        }
                        else{
                            diff[i] += diff[0];
                            treat += diff[0];
                            diff[0] = 0;
                        }
                    }
                }
                if(i == 4){
                    if(diff[0] > 0){
                        if(diff[0] >= Math.abs(diff[i])){
                            diff[0] -= Math.abs(diff[i]);
                            treat += Math.abs(diff[i]);
                            diff[i] = 0;
                        }
                        else{
                            diff[i] += diff[0];
                            treat += diff[0];
                            diff[0] = 0;
                        }
                    }
                    if(diff[2] > 0){
                        if(diff[2] >= Math.abs(diff[i])){
                            diff[2] -= Math.abs(diff[i]);
                            treat += Math.abs(diff[i]);
                            diff[i] = 0;
                        }
                        else{
                            diff[i] += diff[2];
                            treat += diff[2];
                            diff[2] = 0;
                        }
                    }
                }
                if(i == 6){
                    if(diff[0] > 0){
                        if(diff[0] >= Math.abs(diff[i])){
                            diff[0] -= Math.abs(diff[i]);
                            treat += Math.abs(diff[i]);
                            diff[i] = 0;
                        }
                        else{
                            diff[i] += diff[0];
                            treat += diff[0];
                            diff[0] = 0;
                        }
                    }
                    if(diff[2] > 0){
                        if(diff[2] >= Math.abs(diff[i])){
                            diff[2] -= Math.abs(diff[i]);
                            treat += Math.abs(diff[i]);
                            diff[i] = 0;
                        }
                        else{
                            diff[i] += diff[2];
                            treat += diff[2];
                            diff[2] = 0;
                        }
                    }
                    if(diff[4] > 0){
                        if(diff[4] >= Math.abs(diff[i])){
                            diff[4] -= Math.abs(diff[i]);
                            treat += Math.abs(diff[i]);
                            diff[i] = 0;
                        }
                        else{
                            diff[i] += diff[4];
                            treat += diff[4];
                            diff[4] = 0;
                        }
                    }
                }

            }
        }
        for(int i = 0 ; i < 8; i++){
            if(diff[i] < 0){
                //System.out.println(diff[0]);
                if(i == 5 || i == 3){
                    for(int o = 2 ; o >= 0; o--){
                        if(diff[o] > 0){
                            if(diff[o] >= Math.abs(diff[i])){
                                diff[o] -= Math.abs(diff[i]);
                                treat += Math.abs(diff[i]);
                                diff[i] = 0;
                            }
                            else{
                                diff[i] += diff[o];
                                treat += diff[o];
                                diff[o] = 0;
                            }
                        }
                    }
                }
                if(i == 7){
                    for(int o = i-1 ; o >= 0; o--){
                        if(diff[o] > 0){
                            if(diff[o] >= Math.abs(diff[i])){
                                diff[o] -= Math.abs(diff[i]);
                                treat += Math.abs(diff[i]);
                                diff[i] = 0;
                            }
                            else{
                                diff[i] += diff[o];
                                treat += diff[o];
                                diff[o] = 0;
                            }
                        }
                    }
                }

            }
        }
        out.println(treat);


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
