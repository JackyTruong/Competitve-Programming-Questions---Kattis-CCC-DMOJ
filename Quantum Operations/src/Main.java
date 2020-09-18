import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    private static Integer[][] tensorProduct(Integer[][] A, Integer[][] B){
        Integer[][] output = new Integer[A.length*B.length][A[0].length * B[0].length];
        for(int i = 0 ; i < A.length; i++){
            for(int o = 0; o < A[i].length; o++){
                for(int a = 0; a < B.length; a++){
                    for(int b = 0 ; b < B[a].length; b++){
                        output[i*B.length+a][o*B[a].length+b] = A[i][o] * B[a][b];
                    }
                }
            }
        }
        return output;
    }

    public static void main(String[] args)throws IOException {
        br =  new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        ArrayList<Integer[][]> allM = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            int x = nextInt();
            int y = nextInt();
            Integer[][] temp = new Integer[x][y];
            for(int o = 0 ; o < x; o++){
                for(int a = 0; a < y; a++){
                    temp[o][a] = nextInt();
                }
            }
            allM.add(temp);
        }
        Integer[][] temp = allM.get(0);
        for(int i = 1 ; i < allM.size();i++){
            temp = tensorProduct(temp, allM.get(i));
        }
        int largest = -Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int highestRow = -Integer.MAX_VALUE;
        int minRow = Integer.MAX_VALUE;
        for(int i = 0 ; i < temp.length;i++){
            int rowTot = 0;
            for(int o = 0 ; o < temp[0].length;o++){
                rowTot += temp[i][o];
                if(temp[i][o] > largest){
                    largest = temp[i][o];
                }
                if(temp[i][o] < min){
                    min = temp[i][o];
                }
            }
            if(rowTot > highestRow){
                highestRow = rowTot;
            }
            if(rowTot < minRow){
                minRow = rowTot;
            }
        }
        int highestCol = -Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        for(int i = 0 ; i < temp[0].length;i++){
            int colTot = 0;
            for(int o = 0 ; o < temp.length; o++){
                colTot += temp[o][i];
            }
            if(colTot > highestCol){
                highestCol = colTot;
            }
            if(colTot < minCol){
                minCol = colTot;
            }
        }
        out.println(largest);
        out.println(min);
        out.println(highestRow);
        out.println(minRow);
        out.println(highestCol);
        out.println(minCol);

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
