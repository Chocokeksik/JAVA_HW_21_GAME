import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
