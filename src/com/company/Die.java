package com.company;


import java.util.Random;


public class Die {
    public int numberOfSides;
    public int faceUpValue;

    public Die() {
        numberOfSides = 6;
    }

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public int getFaceUpValue() {
        faceUpValue = 1;
        return faceUpValue;
    }

    public int roll() {
        faceUpValue = (int) ((Math.random() * numberOfSides) + 1);


        return faceUpValue;
    }

}
