import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br;

    private static int worth(String trip){
        if(trip.length() == 3){
            if(trip.equals("000")){
                return 0;
            }
            else if(trip.equals("001")){
                return 1;
            }
            else if(trip.equals("010")){
                return 2;
            }
            else if(trip.equals("011")){
                return 3;
            }
            else if(trip.equals("100")){
                return 4;
            }
            else if(trip.equals("101")){
                return 5;
            }
            else if(trip.equals("110")){
                return 6;
            }
            else if(trip.equals("111")){
                return 7;
            }
        }
        else if(trip.length() == 2){
            if(trip.equals("01")){
                return 1;
            }
            else if(trip.equals("10")){
                return 2;
            }
            else if(trip.equals("11")){
                return 3;
            }
        }
        else if(trip.length() == 1){
            if(trip.equals("1")){
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args)throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        int front = temp.length()%3;
        String decimal = "";
        if(front != 0){
            decimal += worth(temp.substring(0, front));
        }
        for(int i = front; i < temp.length(); i+=3){
            decimal += worth(temp.substring(i, i + 3));

        }
        System.out.println(decimal);
    }
}
