import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;
    static int[] count1, count0;
    static int x, y, z;

    private static int binarySearch(int[] arr, int l, int r){
        if(r >= l){
            int mid = l + (r-l)/2;
            if(mid < arr.length){
                if(x-1 >= 0){
                    if(arr[mid]-arr[x-1] == y){
                        return mid;
                    }
                    if(arr[mid]-arr[x-1] > y){
                        return binarySearch(arr, l, mid-1);
                    }
                }
                else{
                    if(arr[mid] == y){
                        return mid;
                    }
                    if(arr[mid] > y){
                        return binarySearch(arr, l, mid-1);
                    }
                }
                return binarySearch(arr, mid+1, r);
            }
        }
        return -1;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        String binary = next();
        count1 = new int[binary.length()];
        count0 = new int[binary.length()];
        int counts1 = 0;
        int counts0 = 0;
        for(int i = 0 ; i < binary.length(); i++){
            if(binary.charAt(i) == '0'){
                counts0++;
            }
            else{
                counts1++;
            }
            count1[i] = counts1;
            count0[i] = counts0;
        }
        /*
        for(int i = 0 ; i < binary.length();i++){
            System.out.println(count1[i] + " " + count0[i]);
        }

         */
        int q = nextInt();
        for(int i = 0 ; i < q; i++){
            x = nextInt()-1; y = nextInt(); z = nextInt();
            if(z == 0){
                int spot;
                if(counts0 >= y){
                     spot = binarySearch(count0, x, binary.length());
                     if(spot != -1){
                         for(int o = spot-1; o >= 0; o--){
                             if(x-1 >= 0){
                                 if(count0[o]-count0[x-1] == y){
                                     spot = o;
                                 }
                                 else{
                                     break;
                                 }
                             }else{
                                 if(count0[o] == y){
                                     spot = o;
                                 }
                                 else{
                                     break;
                                 }
                             }
                         }
                         out.println(spot+1);
                     }
                     else{
                         out.println(spot);
                     }

                }
                else{
                    out.println(-1);
                }
            }
            else{
                int spot;
                if(counts1 >= y){
                    spot = binarySearch(count1, x, binary.length());
                    if(spot != -1){
                        for(int o = spot-1; o >= 0; o--){
                            if(x-1 >= 0){
                                if(count1[o]-count1[x-1] == y){
                                    spot = o;
                                }
                                else{
                                    break;
                                }
                            }else{
                                if(count1[o] == y){
                                    spot = o;
                                }
                                else{
                                    break;
                                }
                            }
                        }
                        out.println(spot+1);
                    }
                    else{
                        out.println(spot);
                    }
                }
                else{
                    out.println(-1);
                }
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
