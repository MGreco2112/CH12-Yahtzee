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

        System.out.println("Which dice do you want to reroll? (1-5)");

        String input = scanner.nextLine();

        player.cup.roll(player.cup.parseSelections(input));
    }

    // TODO refactor turn to trigger scoring and display round score
    public void turn() {
        player.cup.roll();

        for (int i = 0; i < 2; i++) {
            System.out.println(player.cup.displayCup());
            getSelections();
        }

        System.out.println(player.cup.displayCup());
    }

    // TODO refactor play system to run 5 turns and update score *(and display total scores)
    public void play() {
        turn();
    }
}
