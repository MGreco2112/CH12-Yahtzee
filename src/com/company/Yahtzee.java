package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Yahtzee {
    private final Scanner scanner = new Scanner(System.in);
//    public Cup cup = new Cup();
    public Player player;
    public ArrayList<Player> players = new ArrayList<>();
    private final int ROUND = 5;
    private final int MAXPLAYERS = 6;
    private final int MINPLAYER = 1;

    public Yahtzee() {
        System.out.println("How many will be playing Yahtzee?");
        int numberPlayers;
        do {
            numberPlayers = scanner.nextInt();
        }
        while (numberPlayers < MINPLAYER || numberPlayers > MAXPLAYERS);

        scanner.nextLine();

        while (players.size() < numberPlayers) {
            System.out.println("Please enter your name");
            String name = scanner.nextLine().trim();
            players.add(new Player(name));
        }

    }


    public void getSelections(Player activePlayer) {

        System.out.println("Which dice do you want to re-roll? (0-5)");

        String input = scanner.nextLine();

        if (input.equals("")) {
            return;
        }

        activePlayer.cup.roll(activePlayer.cup.parseSelections(input));
    }

    public void turn(Player activePlayer) {
        System.out.println(activePlayer.name + "'s turn, press Enter to begin");
        scanner.nextLine();
        activePlayer.cup.roll();
        int reroll = 2;

        for (int i = 0; i < reroll; i++) {
            System.out.println(activePlayer.cup.displayCup());
            getSelections(activePlayer);
        }

        System.out.println(activePlayer.cup.displayCup());
        System.out.println("Round Score:");
        System.out.println(activePlayer.name + " scored " + activePlayer.updateScore());
        System.out.println("Next Round!");
    }

    private void round() {
        for (Player activePlayer : players) {
            turn(activePlayer);
        }
    }

    private void displayResults() {
        Player currentWinner = players.get(0);

//        for (int i = 1; i < players.size(); i++) {
//            if (currentWinner.score < players.get(i).score) {
//                currentWinner = players.get(i);
//            }
//        }
//
        for (Player player : players) {
            if (currentWinner.score < player.score) {
                currentWinner = player;
            }
            System.out.printf("%s scored %d\n", player.name, player.score);
        }
        System.out.printf(
                "%s is the winner with %d points!!\n",
                currentWinner.name,
                currentWinner.score
        );

    }

    public void play() {
        int turnCount = 0;
        while (turnCount < ROUND) {
            round();
            turnCount++;
        }
        displayResults();

    }
}
