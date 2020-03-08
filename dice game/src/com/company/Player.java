package com.company;

import java.util.LinkedList;

public class Player {
    int points;
    public Player(){
        points = 0;
    }
    public static void addPlayer(LinkedList<Player> players){
        players.add(new Player());
    }


    public static int getPoints(LinkedList<Player> players, int player){
        return players.get(player - 1).points;
    }
}
