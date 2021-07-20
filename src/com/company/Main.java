package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cup cup = new Cup();
        Scanner scanner = new Scanner(System.in);
        String input;


        cup.roll();

        System.out.println(cup.displayCup());

        System.out.println("Which dice do you want to reroll? (1-5)");

        input = scanner.nextLine();

        cup.roll(cup.parseSelections(input));

        System.out.println(cup.displayCup());

        System.out.println("Which dice do you want to reroll? (1-5)");

        input = scanner.nextLine();

        cup.roll(cup.parseSelections(input));

        System.out.println(cup.displayCup());
    }
}
