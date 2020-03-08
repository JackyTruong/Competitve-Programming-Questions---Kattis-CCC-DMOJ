package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws Exception{
        File file =  new File("test.txt");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] counter = new Integer[1001];
        Arrays.fill(counter, 0);
        for(int i = 0; i < n; i++){
            counter[sc.nextInt()]++;
        }
        int largest = 0;
        int secondLargest = 0;
        int num = 0;
        int holder;
        ArrayList<Integer> highest = new ArrayList<>();
        ArrayList<Integer> secondHighest = new ArrayList<>();
        for(int i = 1; i < 1001; i++){
            if(counter[i] > largest){
                largest = counter[i];
            }
        }
        for(int i = 1; i < 1001; i++){
            if(counter[i] == largest){
                highest.add(i);
               //System.out.println("these are the highest" + i);
            }
        }
        for(int i = 1; i < 1001; i++){
            if(counter[i] > secondLargest && counter[i] < largest){
                secondLargest = counter[i];
            }
        }
        for(int i = 1; i < 1001; i++){
            if(counter[i] == secondLargest){
                secondHighest.add(i);
                //System.out.println("these are the second highest" + i);
            }
        }
        if(highest.size() == 1){
            for(int i = 0 ; i < highest.size();i++){
                for(int o = 0; o < secondHighest.size();o++){
                    holder = Math.abs(highest.get(i) - secondHighest.get(o));
                    if(num < holder){
                        num = holder;
                    }

                }
            }
        }
        else{
            for(int i = 0; i < highest.size();i++){
                for(int o = 0 ; o < highest.size();o++){
                    holder = Math.abs(highest.get(i) - highest.get(o));
                    if(num < holder){
                        num = holder;
                    }
                }
            }
        }

        System.out.println(num);
    }
}
