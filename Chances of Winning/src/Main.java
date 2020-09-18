import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[] games;
    static int fav, count;

    private static void addGame(int team1, int team2, int sA, int sB){
        if(team1 == 1){
            if(team2 == 2){
                if(sA > sB){
                    games[0] = 1;
                }
                else if(sA < sB){
                    games[0] = -1;
                }
                else{
                    games[0] = 0;
                }
            }
            else if(team2 == 3){
                if(sA > sB){
                    games[1] = 1;
                }
                else if(sA < sB){
                    games[1] = -1;
                }
                else{
                    games[1] = 0;
                }
            }
            else if(team2 == 4){
                if(sA > sB){
                    games[2] = 1;
                }
                else if(sA < sB){
                    games[2] = -1;
                }
                else{
                    games[2] = 0;
                }
            }
        }
        else if(team1 == 2){
            if(team2 == 3){
                if(sA > sB){
                    games[3] = 1;
                }
                else if(sA < sB){
                    games[3] = -1;
                }
                else{
                    games[3] = 0;
                }
            }
            else if(team2 == 4){
                if(sA > sB){
                    games[4] = 1;
                }
                else if(sA < sB){
                    games[4] = -1;
                }
                else{
                    games[4] = 0;
                }
            }
        }
        else if(team1 == 3){
            if(team2 == 4){
                if(sA > sB){
                    games[5] = 1;
                }
                else if(sA < sB){
                    games[5] = -1;
                }
                else{
                    games[5] = 0;
                }
            }
        }
    }

    private static void fillGames(int[] totalGames){
        boolean foundEmpty = false;
        for(int i = 0 ; i < totalGames.length && !foundEmpty; i++){
            if(totalGames[i] == 2){
                int[] temp = totalGames.clone();
                temp[i] = 1;
                fillGames(temp);
                temp = totalGames.clone();
                temp[i] = 0;
                fillGames(temp);
                temp = totalGames.clone();
                temp[i] = -1;
                fillGames(temp);
                foundEmpty = true;
            }
        }
        int[] temp = new int[4];
        if(!foundEmpty){
            if(totalGames[0] == 1){
                temp[0]+=3;
            }
            else if(totalGames[0] == -1){
                temp[1]+=3;
            }
            else{
                temp[0]++;
                temp[1]++;
            }
            if(totalGames[1] == 1){
                temp[0]+=3;
            }
            else if(totalGames[1] == -1){
                temp[2]+=3;
            }
            else{
                temp[0]++;
                temp[2]++;
            }
            if(totalGames[2] == 1){
                temp[0]+=3;
            }
            else if(totalGames[2] == -1){
                temp[3]+=3;
            }
            else{
                temp[0]++;
                temp[3]++;
            }
            if(totalGames[3] == 1){
                temp[1]+=3;
            }
            else if(totalGames[3] == -1){
                temp[2]+=3;
            }
            else{
                temp[1]++;
                temp[2]++;
            }
            if(totalGames[4] == 1){
                temp[1]+=3;
            }
            else if(totalGames[4] == -1){
                temp[3]+=3;
            }
            else{
                temp[1]++;
                temp[3]++;
            }
            if(totalGames[5] == 1){
                temp[2]+=3;
            }
            else if(totalGames[5] == -1){
                temp[3]+=3;
            }
            else{
                temp[2]++;
                temp[3]++;
            }
            int highest = 0;
            int spot = 0;
            //System.out.println("SCORES");
            boolean noOne = false;
            for(int i = 0 ; i < temp.length; i++){
                //System.out.print(temp[i] + " ");
                if(temp[i] > highest){
                    highest = temp[i];
                    spot = i;
                }
            }

            for(int  i = 0 ; i < temp.length ; i++){
                if(i != spot && temp[i] == highest){
                    noOne = true;
                }
            }

            if(spot+1 == fav && !noOne){
                count++;
            }
            //System.out.println(" " + count);
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        fav = nextInt();
        count = 0;
        int played = nextInt();
        games = new int[6];
        Arrays.fill(games, 2);
        for(int i = 0 ; i < played; i++){
            addGame(nextInt(), nextInt(), nextInt(),nextInt());
        }
        fillGames(games);
        System.out.println(count);

        out.close();
    }

    private static String next()throws IOException{
        while(st==null||!st.hasMoreTokens()){
            st =new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    private static int nextInt()throws IOException{
        return Integer.parseInt(next());
    }

}
