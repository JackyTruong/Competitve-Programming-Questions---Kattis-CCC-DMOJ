package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int numberLetter(char i){
        if(i == 'A'){
            return 0;
        }
        else if(i == 'B'){
            return 1;
        }
        else if(i == 'C'){
            return 2;
        }
         else if(i == 'D'){
            return 3;
        }
        else {
            return 4;
        }
    }

    public static boolean complete(Integer[][] body){
        for(int o = 0; o < 5; o++){
            for(int l = 0; l < 6; l++){
                if(body[o][l] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void changeLights(Integer[][] body,int i, int o){
        Integer[] place = new Integer[2];
        place[0] = 1;
        place[1] = -1;
        if(body[i][o] == 0){
            body[i][o]++;
        }
        else if(body[i][o] == 1){
            body[i][o]--;
        }

        for(int d = 0; d < 2; d++){
            if( i+place[d] >= 0 && i+place[d] <= 4&&body[i + place[d]][o] == 0 ){
                body[i + place[d]][o]++;
            }
            else if( i+place[d] >= 0  && i+place[d] <= 4&& body[i + place[d]][o] == 1){
                body[i + place[d]][o]--;
            }
        }
        for(int d = 0; d < 2; d++){
            if( o+place[d] >= 0&& o+place[d] <= 5&&body[i][o + place[d]] == 0){
                body[i][o + place[d]]++;
            }
            else if( o+place[d] >= 1 && o+place[d] <= 5&&body[i][o + place[d]] == 1){
                body[i][o + place[d]]--;
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] top = new String[6];
        top[0] = " ";
        top[1] = "A";
        top[2] = "B";
        top[3] = "C";
        top[4] = "D";
        top[5] = "E";
        Integer[][] body = new Integer[5][6];
        body[0][0] = 1;
        body[1][0] = 2;
        body[2][0] = 3;
        body[3][0] = 4;
        body[4][0] = 5;
        for(int l = 0; l < 5; l++){
            for(int o = 1; o < 6; o++){
                body[l][o] = (int)(Math.random()*2);
            }
        }
        System.out.println(Arrays.toString(top));
        System.out.println(Arrays.toString(body[0]));
        System.out.println(Arrays.toString(body[1]));
        System.out.println(Arrays.toString(body[2]));
        System.out.println(Arrays.toString(body[3]));
        System.out.println(Arrays.toString(body[4]));
        while(!complete(body)){
            String i = sc.nextLine();
            char[] o = i.toCharArray();
            int a = numberLetter(o[0]);
            changeLights(body, Character.getNumericValue(o[1])-1, a + 1);
            System.out.println(Arrays.toString(top));
            System.out.println(Arrays.toString(body[0]));
            System.out.println(Arrays.toString(body[1]));
            System.out.println(Arrays.toString(body[2]));
            System.out.println(Arrays.toString(body[3]));
            System.out.println(Arrays.toString(body[4]));
        }
    }

}
