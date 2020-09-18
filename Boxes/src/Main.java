
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    static class Box{
        int l, w, h;
        long vol;

        public Box(int A, int B, int C){
            l = A;
            w = B;
            h = C;
            if(l > w){
                int temp = l;
                l = w;
                w = temp;
            }
            if(w > h){
                int temp = w;
                w = h;
                h = temp;
            }
            if(l > w){
                int temp = l;
                l = w;
                w = temp;
            }
            vol = l*w*h;
        }

    }

        public static void main(String[] args) throws IOException {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            int numBoxes = nextInt();
            Box[] boxes = new Box[numBoxes];
            for(int i = 0; i < numBoxes; i++) {
                int l = nextInt(), w = nextInt(), h = nextInt();
                boxes[i] = new Box(l, w, h);
            }
            for(int i = 1; i < numBoxes; i++){
                int o = i-1;
                Box tempBox = boxes[i];
                while(o >= 0 && boxes[o].vol > tempBox.vol){
                    boxes[o+1] = boxes[o];
                    o--;
                }
                boxes[o+1] = tempBox;
            }
            int numItems = nextInt();
            for(int i = 0 ; i < numItems; i++){
                int l = nextInt(), w = nextInt(), h = nextInt();
                Box tempItem = new Box(l, w, h);
                int o = 0;
                while(o < numBoxes && (tempItem.l > boxes[o].l || tempItem.w > boxes[o].w || tempItem.h > boxes[o].h)){
                    o++;
                }
                if(o < numBoxes){
                    out.println(boxes[o].vol);
                }
                else{
                    out.println("Item does not fit.");
                }
            }
            out.close();
        }

        private static String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine().trim());
            }
            return st.nextToken();
        }

        private static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

    }
