package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created 2019-10-21
 */
public class GameRules {

    
    //Instance fields
    
    private int currentNumber;
    private int currentPlayer;
    private int playUntilThisNumber;
    private ArrayList<String> leaderBoard;
    private int dividerToSkip;
    private List<Player> playerlist;


    /**
    * Constructor
    * @param numberOfPlayers
    * @param divider
    */
    public GameRules(int numberOfPlayers, int divider, int playUntilThisNumber){
        playerlist = new ArrayList<Player>();
        currentNumber=1;
        this.playUntilThisNumber = playUntilThisNumber;
        dividerToSkip = divider;
        leaderBoard = new ArrayList<>();
        fillPlayerList(numberOfPlayers);
    }

    /**
    * @return Returns the answer.
    */
    public int getTheAnswer() {
        return 42;
    }

    /**
    * @return Returns the number that is about to be "said" by one of the players.
    */
    public int getCurrentNumber() {
        return currentNumber;
    }

    /**
    *Increases the number to be said by one.
    */
    public int increaseCurrentNumber() {
        this.currentNumber++;
        return currentNumber;
    }

    /**
    * Fills a list of players after the parameters given from the MindRoad.main class.
    * 
    * @param numberOfPlayers
    */
    private void fillPlayerList(int numberOfPlayers){
        Scanner myScanner = new Scanner(System.in);
        for(int i = 0 ; i < numberOfPlayers ; i++){

                System.out.println("player " + (i + 1));

                String playerName = "player: " + (i + 1); // åtgärd för att kunna genomföra tester
                //String playerName = myScanner.nextLine();

            Player p = new Player(this, i+1,dividerToSkip, playerName);
            playerlist.add(p);
        }
    }

    /**
    * Lets the players take turns to play the game of "Burr", passing
    * the turn between players until the playUntilThisNumber is reached.
     */
    public void startGame() {
        while (currentNumber <= playUntilThisNumber) {
            // Print the name of the current player using the currentPlayer index
            Player current = playerlist.get(currentPlayer % playerlist.size());
            System.out.println("NEXT-PLAYER IS --->  " + "Player number: " + currentPlayer + " " + current.getName());

            // Play the game with the current player
            System.out.println(current.play());

            // Move to the next player for the next round
            currentPlayer++;

            // Increment the current number after each play
            increaseCurrentNumber();
        }
    }

    public List<Player> getPlayerlist() {
        return playerlist;
    }

    public ArrayList<String> printLeaderBoard() {

        // Create leaderboard
        for (Player player : playerlist) {
            leaderBoard.add(player.getName() + ": " + player.playerPoint);
        }

        // print leaderboard
        for(String item : leaderBoard) {
            System.out.println(item);
        };

        return leaderBoard;
    }
}