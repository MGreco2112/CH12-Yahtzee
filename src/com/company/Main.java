package com.company;


import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Integer> freq = new TreeMap<>();
        System.out.println(freq);

        Cup cup = new Cup();
        cup.roll();
        for (Die die : cup.dice) {
            if (!freq.containsKey(die.faceUpValue)) {
                freq.put(die.faceUpValue, 0);
            }
            freq.put(die.faceUpValue, freq.get(die.faceUpValue) + 1);
        }
        System.out.println(cup.displayCup());
        System.out.println(freq);

        Yahtzee game = new Yahtzee();
        game.play();

    }
}
