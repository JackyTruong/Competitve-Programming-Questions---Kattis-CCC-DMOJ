package com.company;

import java.util.Random;

public class Dice {
    public static int roll(){
        Random rand = new Random();
        int numberPlayer = rand.nextInt(6);
        return numberPlayer;
    }
}
