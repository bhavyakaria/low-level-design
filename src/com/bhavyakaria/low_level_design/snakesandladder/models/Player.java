package com.bhavyakaria.low_level_design.snakesandladder.models;

public class Player {
    String name;
    int position;
    boolean won;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isWon() {
        return won;
    }
}
