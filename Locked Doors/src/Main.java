import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, T, K, S, Q, spot;
    static int[] diff, answers;
    static Integer[] rooms;
    static ArrayList<Integer[]> completedRooms;
    static boolean[] isOpen;
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static int closest(int direction){
        if(direction == 0){
            for(int i = rooms[spot]; i >= 2; i--){
                if(!isOpen[i-2]){
                    return i-2;
                }
            }
        }
        if(direction == 1){
            for(int i = rooms[spot]; i < N; i++){
                if(!isOpen[i-1]){
                    return i-1;
                }
            }
        }
        return -1;
    }

    private static void goThrough(){
        int closestLeft = closest(0);
        int closestRight = closest(1);
        //System.out.println("here " + spot);
        if(closestLeft != -1 && closestRight != -1){
            if(diff[closestLeft] < diff[closestRight]){
                rooms[spot+1] = closestLeft+1;
                isOpen[closestLeft] = true;
            }
            else if(diff[closestRight] < diff[closestLeft]){
                rooms[spot+1] = closestRight+2;
                isOpen[closestRight] = true;
            }
        }
        else if(closestLeft == -1){
            rooms[spot+1] = closestRight+2;
            isOpen[closestRight] = true;
        }
        else if(closestRight == -1){
            rooms[spot+1] = closestLeft+1;
            isOpen[closestLeft] = true;
        }
        spot++;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        T = nextInt();
        for(int i = 0 ; i < T; i++){
            N = nextInt();Q = nextInt();
            completedRooms = new ArrayList<>();
            diff = new int[N-1];
            for(int o = 0; o < N-1; o++){
                diff[o] = nextInt();
            }
            answers = new int[Q];
            for(int a = 1 ; a <= N; a++){
                rooms = new Integer[N];
                isOpen = new boolean[N-1];
                Arrays.fill(isOpen, false);
                rooms[0] = a;
                spot = 0;
                for(int o = 0; o < N-1; o++){
                    goThrough();
                }
                completedRooms.add(rooms);
            }
            for(int o = 0 ; o < Q; o++){
                S = nextInt();K = nextInt();
                answers[o] = completedRooms.get(S-1)[K-1];
            }
            out.print("Case #" + (i+1) + ": ");
            for(int a = 0 ; a < answers.length; a++){
                if(a < answers.length-1){
                    out.print(answers[a] + " ");
                }
                else{
                    out.println(answers[a]);
                }

            }

        }


        out.close();
    }

    private static String next()throws IOException {
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }


}
