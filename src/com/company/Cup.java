package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cup {
    ArrayList<Die> dice = new ArrayList<>();

    public Cup() {
        while (dice.size() < 5) {
            dice.add(new Die());

        }
    }

    public void roll() {
        for (Die die: dice) {
            die.roll();
        }
    }

    public void roll(int selection) {
        dice.get(selection).roll();
    }

    public void roll(List<Integer> selections) {
        for(int selection: selections) {
            roll(selection);
        }
    }

    public List<Integer> parseSelections(String input) {

        String[] inputArr = input.split(" ");

        ArrayList<Integer> selections = new ArrayList<>();

        for (String number: inputArr) {
            selections.add(Integer.parseInt(number) - 1);
        }

        if (selections.contains(-1)) {
            selections.remove(selections.indexOf(-1));
        }

        return selections;
    }


    public String displayCup() {
        String output = "";
        for (Die die: dice) {
            output += die.faceUpValue + " ";
        }
        return output.trim();
    }


}
