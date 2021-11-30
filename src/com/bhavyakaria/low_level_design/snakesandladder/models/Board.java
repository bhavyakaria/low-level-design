package com.bhavyakaria.low_level_design.snakesandladder.models;

public class Board {
    int size;
    int start;
    int end;

    public Board(int size) {
        this.size = size;
        this.start = 1;
        this.end = start + size - 1;
    }

    public int getSize() {
        return size;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
