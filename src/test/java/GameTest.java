import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    @Test
    public void testFirstPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "V", 100);
        Player player2 = new Player(2, "N", 80);

        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("V", "N");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "V", 10);
        Player player2 = new Player(2, "N", 20);

        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("V", "N");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAllPlayers() {
        Game game = new Game();
        Player player1 = new Player(1, "V", 20);
        Player player2 = new Player(2, "N", 20);

        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("V", "N");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testFirstPlayersException() throws NotFoundException {
        Game game = new Game();
        Player player1 = new Player(1, "V", 20);
        Player player2 = new Player(2, "N", 20);

        game.register(player1);

        Throwable thrown = assertThrows(NotFoundException.class, () -> {
            int actual = game.round(player1.getName(), player2.getName());
        });
        Assertions.assertEquals("Игрок с именем  " + player2.getName() + " Не найден", thrown.getMessage());
    }
    @Test
    public void testSecondPlayersException() throws NotFoundException {
        Game game = new Game();
        Player player1 = new Player(1, "V", 20);
        Player player2 = new Player(2, "N", 20);

        game.register(player2);

        Throwable thrown = assertThrows(NotFoundException.class, () -> {
            int actual = game.round(player1.getName(), player2.getName());
        });
        Assertions.assertEquals("Игрок с именем  " + player1.getName() + " Не найден", thrown.getMessage());
    }
    @Test
    public void testBothPlayersException() throws NotFoundException {
        Game game = new Game();
        Player player1 = new Player(1, "V", 20);
        Player player2 = new Player(2, "N", 20);

        Throwable thrown = assertThrows(NotFoundException.class, () -> {
            int actual = game.round(player1.getName(), player2.getName());
        });
        Assertions.assertEquals("Игрок с именем  " + player1.getName() + " Не найден", thrown.getMessage());
    }
}
