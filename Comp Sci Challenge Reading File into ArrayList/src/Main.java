import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException {
        File file = new File("Test.txt");
        Scanner sc = new Scanner(file);
        ArrayList<String> input = new ArrayList<>();
        while(sc.hasNextLine()){
            input.add(sc.nextLine());
        }
        for(int i = 0 ; i < input.size();i++){
            System.out.println(input.get(i));
        }
    }
}
