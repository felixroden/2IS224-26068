package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameRulesTest {
    GameRules gameRules;
    int playUntil = 100;
    int totalPlayers = 5;

    GameRulesTest() {
    }

    @BeforeEach
    void setUp() {
        this.gameRules = new GameRules(this.totalPlayers, 7, this.playUntil);
    }

    @Test
    void getCurrentNumber() {
        Assertions.assertEquals(10, this.gameRules.getCurrentNumber());
    }

    @Test
    void increaseCurrentNumber() {
        Assertions.assertNotEquals(1, this.gameRules.increaseCurrentNumber());
    }

    @Test
    void startGame() {
        this.gameRules.startGame();
        Assertions.assertEquals(this.playUntil + 1, this.gameRules.getCurrentNumber());
    }

    @Test
    void printLeaderBoard() {
        Assertions.assertEquals(this.totalPlayers, this.gameRules.printLeaderBoard().size());
    }
}
