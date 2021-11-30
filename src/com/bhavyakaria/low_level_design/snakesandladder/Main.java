package com.bhavyakaria.low_level_design.snakesandladder;

import com.bhavyakaria.low_level_design.snakesandladder.models.Ladder;
import com.bhavyakaria.low_level_design.snakesandladder.models.Player;
import com.bhavyakaria.low_level_design.snakesandladder.models.Snake;
import com.bhavyakaria.low_level_design.snakesandladder.services.GameService;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        System.out.println("Enter Snakes Data");
        int numOfSnakes = sc.nextInt();
        List<Snake> snakes = new ArrayList<>(numOfSnakes);

        for (int i = 0; i < numOfSnakes; i++) {
            Snake snake = new Snake(sc.nextInt(), sc.nextInt());
            snakes.add(snake);
        }

//        System.out.println("Enter Ladders Data");
        int numOfLadders = sc.nextInt();
        List<Ladder> ladders = new ArrayList<>(numOfLadders);

        for (int i = 0; i < numOfLadders; i++) {
            Ladder ladder = new Ladder(sc.nextInt(), sc.nextInt());
            ladders.add(ladder);
        }

//        System.out.println("Enter Players Data");
        int numOfPlayers = sc.nextInt();
        Queue<Player> players = new LinkedList<>();

        for (int i = 0; i < numOfPlayers; i++) {
            Player player = new Player(sc.next());
            players.add(player);
        }

        GameService game = new GameService(snakes, ladders, players, 100);
        game.startGame();
    }
}
