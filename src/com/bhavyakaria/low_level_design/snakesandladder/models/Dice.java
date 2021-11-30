package com.bhavyakaria.low_level_design.snakesandladder.models;

import java.util.Random;

public class Dice {
    int minValue;
    int maxValue;

    public Dice(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int rollDice() {
        return new Random().nextInt(maxValue - minValue + 1) + minValue;
    }
}
