package com.company;

import java.util.Random;
import java.util.Arrays;

public class Main {


    private static void rows(int l) {
        for (int i=0; i<l; i++)
            System.out.print("-----------");
        System.out.println("-");

    }

    private static void displayArray(String game[][]){
        for (int row =0; row < game.length; row++) {
            rows(game[0].length);


            for (int col=0; col<game[0].length; col++)
                    System.out.printf("|%-6s %3s", game[row][col], "");

            System.out.println("|");
        }
        rows(game[0].length);
    }


    public static int randomLocation() {

        Random r = new Random();

        int x = r.nextInt(5);

        return x;

    }

    public static void prizes(String game[][] ) {
        int o = 0;
        while(o < 5){
            for (int i = 0; i<3; i++) {
                int x = randomLocation();
                int y = randomLocation();
                if(game[x][y] == " "){
                    if(o == 0){
                        game[x][y] = "Puzzle";
                    }
                    else if(o == 1){
                        game[x][y] = "Poster";
                    }
                    else if(o == 2){
                        game[x][y] = "Game";
                    }
                    else if(o == 3){
                        game[x][y] = "Ball";
                    }
                    else{
                        game[x][y] = "Doll";
                    }
                }
                else{
                    i--;
                }


            }

            o++;
        }

    }
    public static void pennies(String game[][]){
        int puzzle = 0, poster = 0, games = 0, ball = 0, doll = 0;
        int[][] spots = new int[5][5];
        for(int i = 0; i < 10; i++){
            int x  = randomLocation();
            int y = randomLocation();
            if(spots[x][y] != 1){
                spots[x][y] = 1;
                if(game[x][y] == "Game"){
                    game[x][y] = "Game*";
                    games++;
                }
                else if(game[x][y] == "Puzzle"){
                    game[x][y] = "Puzzle*";
                    puzzle++;
                }
                else if(game[x][y] == "Poster"){
                    game[x][y] = "Poster*";
                    poster++;
                }
                else if(game[x][y] == "Ball"){
                    game[x][y] = "Ball*";
                    ball++;
                }
                else if (game[x][y] == "Doll"){
                    game[x][y] = "Doll*";
                    doll++;
                }
                else{
                    game[x][y] = "*";
                }
            }

        }
        displayArray(game);
        if(puzzle == 3){
            System.out.println("You won a Puzzle!");
        }
        else if(poster == 3){
            System.out.println("You won a Poster!");
        }
        else if(games == 3){
            System.out.println("You won a Game!");
        }
        else if(ball == 3){
            System.out.println("You won a Ball!");
        }
        else if(doll == 3){
            System.out.println("You won a Doll!");
        }
        else{
            System.out.println("You lost!");
        }
    }

    public static void fillEmpty(String[][] game){
        for(int o = 0; o < 5; o++){
            Arrays.fill(game[o], " ");
        }
    }

    public static void main(String[] args) {

        String game[][] = new String [5][5];
        fillEmpty(game);
        prizes(game);
        pennies(game);

    }

}
