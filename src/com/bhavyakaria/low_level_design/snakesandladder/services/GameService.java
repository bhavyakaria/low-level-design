package com.bhavyakaria.low_level_design.snakesandladder.services;

import com.bhavyakaria.low_level_design.snakesandladder.models.*;

import java.util.*;

public class GameService {

    private Queue<Player> players;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    private Board board;
    private Dice dice;

    public GameService(List<Snake> snakes, List<Ladder> ladders, Queue<Player> players, int boardSize) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        board = new Board(boardSize);
        dice = new Dice(1, 6);
    }

    public void startGame() {
        System.out.println("Game started");
        while (true) {
            Player currentPlayer = players.poll();
            int diceNum = dice.rollDice();
            int newPosition = getNewPosition(currentPlayer.getPosition(), diceNum);

            System.out.println(currentPlayer.getName() + " rolled a " + diceNum + " and moved from " + currentPlayer.getPosition() + " to " + newPosition);
            if (newPosition == board.getEnd()) {
                currentPlayer.setWon(true);
                System.out.println(currentPlayer.getName() + " won!");
                break;
            } else if (newPosition > board.getEnd()) {
                players.add(currentPlayer);
            } else {
                currentPlayer.setPosition(newPosition);
                players.add(currentPlayer);
            }
        }
    }

    public int getNewPosition(int currentPosition, int diceNum) {
        int newPosition = currentPosition + diceNum;

        if (newPosition > board.getEnd()) {
            return currentPosition;
        }

        for (Snake snake : snakes) {
            if (snake.getHead() == newPosition) {
                System.out.println("Snake bite at position " + newPosition);
                newPosition = getNewPosition(snake.getTail(), 0);
                return newPosition;
            }
        }

        for (Ladder ladder : ladders) {
            if (ladder.getStart() == newPosition) {
                System.out.println("Lucky Ladder at " + newPosition);
                newPosition = getNewPosition(ladder.getEnd(), 0);
                return newPosition;
            }
        }
        return newPosition;
    }

}
