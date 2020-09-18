import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static long[][] glass;
    static int size, amount, block;

    private static void createGlass(){
        block/=5;
        for(int i = block; i < amount-block; i++){
            for(int o = 0 ; o < block; o++){
                glass[o][i] = 1;
            }
        }
        for(int i = block*2; i < block+(block*2); i++){
            for(int o = block ; o < block*2; o++){
                glass[o][i] = 1;
            }
        }
    }

    private static void addGlass(){
        int temp = block;
        block/=5;
        for(int i = 0 ; i < amount-temp;i++){
            for(int o = 0 ; o < amount-temp;o++){
                boolean isOne = true;
                for(int a = 0 ;a < temp; a++){
                    if(glass[i][o+a] != 1 || (glass[i][o-1] == 1 && glass[i][o+temp] == 1)){
                        isOne = false;
                    }
                }
                if(isOne){
                    for(int a = block; a < block*2; a++){
                        for(int b = 0 ; b < block; b++){
                            glass[i+b+1][a+o] = 1;
                        }
                    }
                    for(int a = block*2; a< block*2+(block*2); a++){
                        for(int b = 0; b < block;b++){
                            glass[i+b+1][a+o] = 1;
                        }
                    }
                    for(int a = block*2; a < block*2+block; a++){
                        for(int b = block ; b < block*2; b++){
                            glass[i+b+1][a+o] = 1;
                        }
                    }
                }

            }
        }
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int num = nextInt();
        for(int i = 0 ; i < num ; i++){
            size = nextInt();
            int lookX = nextInt();
            int lookY = nextInt();
            amount = (int)Math.pow(5,size);
            block = (int)Math.pow(5,size);
            glass = new long[amount][amount];
            createGlass();
            for(int a = 0 ; a < size-1; a++){
                addGlass();
            }
            if(glass[lookY][lookX] == 1){
                out.println("crystal");
            }
            else{
                out.println("empty");
            }
            /*
            for(int a = 0 ; a < amount; a++){
                System.out.println(Arrays.toString(glass[a]));

            }

             */
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
