package com.company;
import java.util.LinkedList;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        LinkedList<Player> players = new LinkedList<Player>();
        Player.addPlayer(players);
        Player.addPlayer(players);
        while(players.get(0).points < 10 && players.get(1).points < 10){
            int player1 = 0;
            int player2 = 0;

            System.out.println("Type roll to roll for player 1");
            Scanner scanner = new Scanner(System.in);
            String roll = scanner.nextLine();
            if(roll.equals("roll")){
                player1 = Dice.roll();
            }
            System.out.println("Type roll to roll for player 2");
            roll = scanner.nextLine();
            if(roll.equals("roll")){
                player2 = Dice.roll();
            }
            if(player1 > player2){
                players.get(0).points += player1;
            }
            else if(player1 == player2){

            }
            else{
                players.get(1).points += player2;
            }
            System.out.println("Player one has " + Player.getPoints(players, 1) + " points.");
            System.out.println("Player two has " + Player.getPoints(players,2) + " points.");
        }

    }
}

