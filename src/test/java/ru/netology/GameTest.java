package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test

    public void WhenTheFirstPlayerIsNotRegistered() {
        Player anton = new Player(1, "Антон", 60);
        Player kirill = new Player(2, "Кирилл", 90);
        Game game = new Game();

        game.register(anton);
        game.register(kirill);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Антон", "Василий")
        );

    }

    @Test

    public void WhenTheSecondPlayerIsNotRegistered() {
        Player anton = new Player(1, "Антон", 60);
        Player kirill = new Player(2, "Кирилл", 90);
        Game game = new Game();

        game.register(anton);
        game.register(kirill);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Василий", "Кирилл")
        );

    }

    @Test
    public void WhenTheFirstPlayerIsStronger() {
        Player anton = new Player(1, "Антон", 60);
        Player kirill = new Player(2, "Кирилл", 90);
        Game game = new Game();

        game.register(anton);
        game.register(kirill);

        int expected = 1;
        int actual = game.round("Кирилл", "Антон");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenTheSecondPlayerIsStronger() {
        Player anton = new Player(1, "Антон", 90);
        Player kirill = new Player(2, "Кирилл", 70);
        Game game = new Game();

        game.register(anton);
        game.register(kirill);

        int expected = 2;
        int actual = game.round("Кирилл", "Антон");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void WhenTheStrengthOfThePlayersIsEqual() {
        Player anton = new Player(1, "Антон", 80);
        Player kirill = new Player(2, "Кирилл", 80);
        Game game = new Game();

        game.register(anton);
        game.register(kirill);

        int expected = 0;
        int actual = game.round("Антон", "Кирилл");

        Assertions.assertEquals(expected, actual);
    }
}


