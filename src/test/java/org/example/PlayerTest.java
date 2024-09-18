package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
    GameRules gameRules;
    int playUntil = 10;
    int totalPlayers = 1;
    int divider = 3;

    PlayerTest() {
    }

    @BeforeEach
    void setUp() {
        this.gameRules = new GameRules(this.totalPlayers, this.divider, this.playUntil);
    }

    // TESTING
    @Test
    void playerPoint() {
        for(int i = 1; i < 3; ++i) {
            this.gameRules.increaseCurrentNumber();
        }

        Player player = (Player)this.gameRules.getPlayerlist().getFirst();
        ((Player)this.gameRules.getPlayerlist().getFirst()).play();
        Assertions.assertEquals(1, player.playerPoint());
    }

    @Test
    void getName() {
        Player player = (Player)this.gameRules.getPlayerlist().getFirst();
        Assertions.assertEquals("player: 1", player.getName());
    }

    @Test
    void play() {
        for(int i = 1; i < 3; ++i) {
            this.gameRules.increaseCurrentNumber();
        }

        String result = ((Player)this.gameRules.getPlayerlist().getFirst()).play();
        Assertions.assertTrue(result.endsWith("|____/ \\__,_|_|  |_|          "));
    }
}
