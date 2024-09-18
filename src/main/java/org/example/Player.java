package org.example;


import java.util.HashMap;
import java.util.Scanner;

/**
 * Created 2019-10-21
 */
public class Player {

    //Instance fields

    private GameRules rules;
    private int dividerToSkip;
    private int playerNumber;

    private String playerName;


    int playerPoint = 0;

    public int playerPoint()
    {
        return playerPoint;
    }
    /**
     * Constructor
     *
     * @param r          - rules for the game
     * @param playerNr   - which player in turn
     * @param divider    - divider for the game
     * @param playerName
     */
    public Player(GameRules r, int playerNr, int divider, String playerName){
        rules = r;
        dividerToSkip = divider;
        playerNumber = playerNr;
        this.playerName = playerName;
    }

    /**
    * Checks the GameRule class for info on the game's state
    * @return  a string depending on the outcome.
     */
    public String getName(){
        return playerName;
    }
    public String play() {
        String s;
        if(rules.getCurrentNumber()%dividerToSkip==0){
            s = playerName + " " + playerNumber + ":   ____                  \n" +
                    "| __ ) _   _ _ __ _ __ \n" +
                    "|  _ \\| | | | '__| '__|\n" +
                    "| |_) | |_| | |  | |   \n" +
                    "|____/ \\__,_|_|  |_|          ";

            playerPoint++;
        }
        else {

            s = playerName  + " " + playerNumber + ": " + rules.getCurrentNumber();
        }
        rules.increaseCurrentNumber();
        return s;
    }
}
