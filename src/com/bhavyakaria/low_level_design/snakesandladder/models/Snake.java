package com.bhavyakaria.low_level_design.snakesandladder.models;

public class Snake {
    int head;
    int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
