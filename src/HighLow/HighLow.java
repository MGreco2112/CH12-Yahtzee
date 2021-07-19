package HighLow;

import com.company.Die;

import java.util.Scanner;

public class HighLow {

    public static void play() {

        boolean isLoser = false;
        int winStreak = 0;
        boolean initialDie1Roll = true;
        boolean initialDie2Roll = true;
        int lastRoundDie1 = 0;
        int lastRoundDie2 = 0;

        while (!isLoser) {
            Scanner scanner = new Scanner(System.in);
            Die die1 = new Die();
            Die die2 = new Die();
            int die1Roll;
            int die2Roll;

            if (initialDie1Roll && initialDie2Roll) {
                die1Roll = die1.roll();
                die2Roll = die2.roll();
            } else {
                die1Roll = lastRoundDie1;
                die2Roll = lastRoundDie2;
            }

            int oldTotal = die1Roll + die2Roll;

            System.out.println(die1Roll + " + " + die2Roll + " = " + oldTotal);
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
            lastRoundDie1 = die1.faceUpValue;
            lastRoundDie2 = die2.faceUpValue;

            if (input.equals("h")) {
                if (isLarger) {
                    initialDie1Roll = false;
                    initialDie2Roll = false;
                    winStreak++;
                    System.out.println("You win! Current streak: " + winStreak);
                } else {
                    System.out.println("You lose! Total streak: " + winStreak);
                    isLoser = true;
                }
            } else {
                if (isLarger) {
                    System.out.println("You lose! Total streak: " + winStreak);
                    isLoser = true;
                } else {
                    initialDie1Roll = false;
                    initialDie2Roll = false;
                    winStreak++;
                    System.out.println("You win! Current streak: " + winStreak);
                }
            }
        }

    }
}
