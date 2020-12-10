import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = nextInt();
        for(int i = 0 ;i < n;i++){
            boolean isOne = false;
            char[] notes = new char[4];
            for(int o = 0; o < 4;o++){
                notes[o] = nextChar();
            }
            if(notes[0] == 'G'){
                if(notes[1] == 'B'){
                    if(notes[2] == 'D'){
                        if(notes[3] == 'F'){
                            out.println("root");
                            isOne = true;
                        }
                    }
                }
            }
            else if(notes[0] == 'B'){
                if(notes[1] == 'D'){
                    if(notes[2] == 'F'){
                        if(notes[3] == 'G'){
                            out.println("first");
                            isOne = true;
                        }
                    }
                }
            }
            else if(notes[0] == 'D'){
                if(notes[1] == 'F'){
                    if(notes[2] == 'G'){
                        if(notes[3] == 'B'){
                            out.println("second");
                            isOne = true;
                        }
                    }
                }
            }
            else if(notes[0] == 'F'){
                if(notes[1] == 'G'){
                    if(notes[2] == 'B'){
                        if(notes[3] == 'D'){
                            out.println("third");
                            isOne = true;
                        }
                    }
                }
            }
            if(!isOne){
                out.println("invalid");
            }
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

    private static char nextChar()throws IOException{
        return next().charAt(0);
    }

}
