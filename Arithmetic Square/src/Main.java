import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void rowChanger(Integer[][] numbers){
       // System.out.println("this ");
        for(int o = 0; o < 3; o++){
            for(int l = 0; l < 3;l++){
                if(numbers[o][l] == null){
                    if(l == 0 && numbers[o][l+1] != null && numbers[o][l+2] != null){
                        numbers[o][l] = numbers[o][l+1] + (numbers[o][l+1] - numbers[o][l+2]);
                        //System.out.println("this worked");
                    }
                    else if(l == 2 && numbers[o][l-2] != null && numbers[o][l-1] != null){
                        numbers[o][l] = numbers[o][l-1] + (numbers[o][l-1] - numbers[o][l-2]);
                        //System.out.println("this secondary worked");
                    }
                    else if(l == 1 && numbers[o][l-1] != null && numbers[o][l+1] != null){
                        numbers[o][l] = numbers[o][l-1] - (numbers[o][l-1] - numbers[o][l+1])/2;
                    }
                }
            }
        }
        for (int o = 0; o < 3; o++) {
            for (int l = 0; l < 3; l++) {
                if (numbers[o][l] == null) {
                    if (o == 0 && numbers[o + 2][l] != null && numbers[o + 1][l] != null) {
                        numbers[o][l] = numbers[o + 1][l] + (numbers[o + 1][l] - numbers[o + 2][l]);
                    } else if (o == 2 && numbers[o - 1][l] != null && numbers[o - 2][l] != null) {
                        numbers[o][l] = numbers[o - 1][l] + (numbers[o - 1][l] - numbers[o - 2][l]);
                    } else if (o == 1 && numbers[o + 1][l] != null && numbers[o - 1][l] != null) {
                        numbers[o][l] = numbers[o - 1][l] - (numbers[o - 1][l] - numbers[o + 1][l]) / 2;
                    }
                }
            }
        }
    }


    public static void fillFirst(Integer[][] numbers){
        if((numbers[0][0] == null && numbers[0][1] == null )|| (numbers[0][1] == null  && numbers[0][2] == null) || (numbers[0][0] == null && numbers[0][2] == null)){
            if(numbers[0][0] == null && numbers[0][1] == null){
                numbers[0][0] = numbers[0][2];
                numbers[0][1] = numbers[0][2];
            }
            if(numbers[0][1] == null && numbers[0][2] == null){
                numbers[0][2] = numbers[0][0];
                numbers[0][1] = numbers[0][0];
            }
            if(numbers[0][2] == null && numbers[0][0] == null){
                numbers[0][0] = numbers[0][1];
                numbers[0][2] = numbers[0][1];
            }
        }
        else{
            if(numbers[0][0] == null && numbers[0][1] == null){
                numbers[0][0] = -(numbers[0][2]);
                numbers[0][1] = 0;
            }
            if(numbers[0][1] == null && numbers[0][2] == null){
                numbers[0][2] = numbers[0][0]*3;
                numbers[0][1] = numbers[0][0]*2;
            }
            if(numbers[0][2] == null && numbers[0][0] == null){
                numbers[0][0] = 0;
                numbers[0][2] = numbers[0][1]*2;
            }
        }
    }
    public static void fillThird(Integer[][]numbers){
        if((numbers[2][0] == null && numbers[2][1] == null )|| (numbers[2][1] == null  && numbers[2][2] == null) || (numbers[2][0] == null && numbers[2][2] == null)){
            if(numbers[2][0] == null && numbers[2][1] == null){
                numbers[2][0] = numbers[2][2];
                numbers[2][1] = numbers[2][2];
            }
            if(numbers[2][1] == null && numbers[2][2] == null){
                numbers[2][2] = numbers[2][0];
                numbers[2][1] = numbers[2][0];
            }
            if(numbers[2][2] == null && numbers[2][0] == null){
                numbers[2][0] = numbers[2][1];
                numbers[2][2] = numbers[2][1];
            }
        }
        else{
            if(numbers[2][0] == null && numbers[2][1] == null){
                numbers[2][0] = -(numbers[2][2]);
                numbers[2][1] = 0;
            }
            if(numbers[2][1] == null && numbers[2][2] == null){
                numbers[2][2] = numbers[2][0]*3;
                numbers[2][1] = numbers[2][0]*2;
            }
            if(numbers[2][2] == null && numbers[2][0] == null){
                numbers[2][0] = 0;
                numbers[2][2] = numbers[2][1]*2;
            }
        }
    }

    public static void fillSecond(Integer[][]numbers){
        if((numbers[1][0] == null && numbers[1][1] == null )|| (numbers[1][1] == null  && numbers[1][2] == null) || (numbers[1][0] == null && numbers[1][2] == null)){
            if(numbers[1][0] == null && numbers[1][1] == null){
                numbers[1][0] = numbers[1][2];
                numbers[1][1] = numbers[1][2];
            }
            if(numbers[1][1] == null && numbers[1][2] == null){
                numbers[1][2] = numbers[1][0];
                numbers[1][1] = numbers[1][0];
            }
            if(numbers[1][2] == null && numbers[1][0] == null){
                numbers[1][0] = numbers[1][1];
                numbers[1][2] = numbers[1][1];
            }
        }
        else{
            if(numbers[1][0] == null && numbers[1][1] == null){
                numbers[1][0] = -(numbers[1][2]);
                numbers[1][1] = 0;
            }
            if(numbers[1][1] == null && numbers[1][2] == null){
                numbers[1][2] = numbers[1][0]*3;
                numbers[1][1] = numbers[1][0]*2;
            }
            if(numbers[1][2] == null && numbers[1][0] == null){
                numbers[1][0] = 0;
                numbers[1][2] = numbers[1][1]*2;
            }
        }
    }

    public static void columnFirst(Integer[][] numbers){
        if((numbers[0][0] == null && numbers[1][0] == null )|| (numbers[1][0] == null  && numbers[2][0] == null) || (numbers[0][0] == null && numbers[2][0] == null)){
            if(numbers[0][0] == null && numbers[1][0] == null){
                numbers[0][0] = numbers[2][0];
                numbers[1][0] = numbers[2][0];
            }
            if(numbers[1][0] == null && numbers[2][0] == null){
                numbers[2][0] = numbers[0][0];
                numbers[1][0] = numbers[0][0];
            }
            if(numbers[2][0] == null && numbers[0][0] == null){
                numbers[0][0] = numbers[1][0];
                numbers[2][0] = numbers[1][0];
            }
        }
        else{
            if(numbers[0][0] == null && numbers[1][0] == null){
                numbers[0][0] = -(numbers[2][0]);
                numbers[1][0] = 0;
            }
            if(numbers[1][0] == null && numbers[2][0] == null){
                numbers[2][0] = numbers[0][0]*3;
                numbers[1][0] = numbers[0][0]*2;
            }
            if(numbers[2][0] == null && numbers[0][0] == null){
                numbers[0][0] = 0;
                numbers[2][0] = numbers[1][0]*2;
            }
        }
    }

    public static void columnSecond(Integer[][] numbers){
        if((numbers[0][1] == null && numbers[1][1] == null )|| (numbers[1][1] == null  && numbers[2][1] == null) || (numbers[0][1] == null && numbers[2][1] == null)){
            if(numbers[0][1] == null && numbers[1][1] == null){
                numbers[0][1] = numbers[2][1];
                numbers[1][1] = numbers[2][1];
            }
            if(numbers[1][1] == null && numbers[2][1] == null){
                numbers[2][1] = numbers[0][1];
                numbers[1][1] = numbers[0][1];
            }
            if(numbers[2][1] == null && numbers[0][1] == null){
                numbers[0][1] = numbers[1][1];
                numbers[2][1] = numbers[1][1];
            }
        }
        else{
            if(numbers[0][1] == null && numbers[1][1] == null){
                numbers[0][1] = -(numbers[2][1]);
                numbers[1][1] = 0;
            }
            if(numbers[1][1] == null && numbers[2][1] == null){
                numbers[2][1] = numbers[0][1]*3;
                numbers[1][1] = numbers[0][1]*2;
            }
            if(numbers[2][1] == null && numbers[0][1] == null){
                numbers[0][1] = 0;
                numbers[2][1] = numbers[1][1]*2;
            }
        }
    }

    public static void columnThird(Integer[][] numbers){
        if((numbers[0][2] == null && numbers[1][2] == null )|| (numbers[1][2] == null  && numbers[2][2] == null) || (numbers[0][2] == null && numbers[2][2] == null)){
            if(numbers[0][2] == null && numbers[1][2] == null){
                numbers[0][2] = numbers[2][2];
                numbers[1][2] = numbers[2][2];
            }
            if(numbers[1][2] == null && numbers[2][2] == null){
                numbers[2][2] = numbers[0][2];
                numbers[1][2] = numbers[0][2];
            }
            if(numbers[2][2] == null && numbers[0][2] == null){
                numbers[0][2] = numbers[1][2];
                numbers[2][2] = numbers[1][2];
            }
        }
        else{
            if(numbers[0][2] == null && numbers[1][2] == null){
                numbers[0][2] = -(numbers[2][2]);
                numbers[1][2] = 0;
            }
            if(numbers[1][2] == null && numbers[2][2] == null){
                numbers[2][2] = numbers[0][2]*3;
                numbers[1][2] = numbers[0][2]*2;
            }
            if(numbers[2][2] == null && numbers[0][2] == null){
                numbers[0][2] = 0;
                numbers[2][2] = numbers[1][2]*2;
            }
        }
    }

    public static boolean anyX(Integer[][] numbers){
        for(int o = 0; o < 3; o++){
            for(int l = 0; l < 3; l++){
                if(numbers[o][l] == null){
                    return true;
                }
            }
        }
        return false;
    }

    public static void allX(Integer[][] numbers){
        Integer[]xLocations = new Integer[9];
        Integer[]yLocations = new Integer[9];
        int counter = 0;
        for(int o = 0; o < 3; o++){
            for(int l = 0; l < 3; l++){
                if(numbers[o][l] == null){
                    xLocations[counter] = o;
                    yLocations[counter] = l;
                    counter++;
                }
            }
        }

        if(counter == 9){
            for(int o = 0; o < 3; o++){
                for(int l = 0; l < 3; l++){
                    if(numbers[o][l] == null){
                        numbers[o][l] = 0;
                    }
                }
            }
        }
    }



    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("s3.sample02.IN");
        Integer[][] numbers = new Integer[3][3];
        Scanner sc = new Scanner(file);
       for(int o = 0; o < 3;o++){
           for(int i = 0; i < 3; i++){
               if(sc.hasNextInt()){
                   numbers[o][i] = sc.nextInt();
                   System.out.println(numbers[o][i]);
               }
               else{
                   sc.next();
                   numbers[o][i] = null;
               }
           }
       }
      // if(xCounter(numbers) <= 5){
        int counter = 0;
        while(anyX(numbers)){
            allX(numbers);
            rowChanger(numbers);
            fillFirst(numbers);
            if(counter >= 1){
                fillSecond(numbers);
                if(counter >=2){
                    fillThird(numbers);
                    columnFirst(numbers);
                    columnSecond(numbers);
                    columnThird(numbers);
                }
            }
            counter++;
        }

     //  }
      // else{
        //   allSameNumbers(numbers);
      // }

        System.out.println(Arrays.deepToString(numbers));

    }
}
