package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // add boolean state to signify if a win has occured. While loop the code to continue running if bool is false.

        boolean isWinner = false;

        while (!isWinner) {
            Scanner scanner = new Scanner(System.in);
            Die die1 = new Die();
            Die die2 = new Die();

            die1.roll();
            die2.roll();

            int oldTotal = die1.faceUpValue + die2.faceUpValue;

            System.out.println(die1.faceUpValue + " + " + die2.faceUpValue + " = " + oldTotal);
            System.out.println("Will the next number be (h)igher or (l)ower?");
            String input = scanner.next();

            die1.roll();
            die2.roll();

            int total = die1.faceUpValue + die2.faceUpValue;

            if (oldTotal == total) {
                System.out.println("Same number, you lose!");
            }


            boolean isLarger = total > oldTotal;
            System.out.println(die1.faceUpValue + " + " + die2.faceUpValue + " = " + total);

            if (input == "h") {
                if (isLarger) {
                    System.out.println("You win!");
                    isWinner = true;
                } else {
                    System.out.println("You lose!");
                }
            } else {
                if (isLarger) {
                    System.out.println("You lose!");
                } else {
                    System.out.println("You win!");
                    isWinner = true;
                }
            }
        }
    }
}
