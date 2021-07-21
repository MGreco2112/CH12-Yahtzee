package com.company;

import java.util.Scanner;

public class Yahtzee {
    private final Scanner scanner = new Scanner(System.in);
//    public Cup cup = new Cup();
    public Player player;

    public Yahtzee() {
        System.out.println("Please enter your name");
        String name = scanner.nextLine().trim();
        this.player = new Player(name);
    }


    public void getSelections() {

        System.out.println("Which dice do you want to re-roll? (0-5)");

        String input = scanner.nextLine();

        player.cup.roll(player.cup.parseSelections(input));
    }

    public void turn() {
        player.cup.roll();

        for (int i = 0; i < 2; i++) {
            System.out.println(player.cup.displayCup());
            getSelections();
        }

        System.out.println(player.cup.displayCup());
        System.out.println("Round Score:");
        System.out.println(player.updateScore());
        System.out.println("Next Round!");
    }

    public void play() {
        int turnCount = 0;
        while (turnCount < 5) {
            turn();
            turnCount++;
        }
        System.out.println(player.name + " ended with a score of " + player.score + " points!\nGame Over");
    }
}
