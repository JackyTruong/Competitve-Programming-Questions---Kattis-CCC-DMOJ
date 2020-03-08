package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static int treeFinder(int w, LinkedList<Integer> trees){
        if(trees.get(w) != 0){
            return trees.get(w);
        }
        int total = 0;
        for(int a = 2; a <= w; a++){
            int b = w/a;
            if(trees.get(b) != 0){
                total += trees.get(b);

            }
            else{
                total += treeFinder(b, trees);
            }
        }

        trees.set(w, total);
        return total;
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int w = sc.nextInt();
	LinkedList<Integer> trees1 = new LinkedList<>();
	for(int c = 0; c <= w; c++){
	    trees1.add(0);
    }
	trees1.set(1, 1);
	System.out.println(treeFinder(w, trees1));



    }
}
