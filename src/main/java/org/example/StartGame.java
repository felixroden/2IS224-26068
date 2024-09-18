package org.example;

import java.util.Scanner;

/**
 * Created 2019-10-21
 */
public class StartGame {
    public void start() {
        System.out.println("Hello welcome");
        Scanner myScanner = new Scanner(System.in);
        System.out.println("How many players?");
        int numberPlayers = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("What number do you want to play to?");
        int playUntilThisNumber = myScanner.nextInt();

        System.out.println("What number do you want to be the divider?");
        int divider = myScanner.nextInt();

        GameRules gr = new GameRules(numberPlayers,divider, playUntilThisNumber);
        gr.startGame();
        gr.printLeaderBoard();
    }
}