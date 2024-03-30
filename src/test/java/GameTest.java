import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


class GameTest {
    @Test
    public void whenSecondPlayerWinTest() {
        Player pasha = new Player(123, "Паша", 120);
        Player dima = new Player(1241254, "Дима", 100);
        Game game = new Game();

        game.register(pasha);
        game.register(dima);
        int actual = game.round("Дима","Паша");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenFirstPlayerWinTest() {
        Player dima = new Player(1, "Дима", 120);
        Player pasha = new Player(2, "Паша", 100);
        Game game = new Game();

        game.register(dima);
        game.register(pasha);
        int actual = game.round("Дима","Паша");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenNobodyWinTest() {
        Player dima = new Player(1, "Дима", 100);
        Player pasha = new Player(2, "Паша", 100);
        Game game = new Game();

        game.register(dima);
        game.register(pasha);
        int actual = game.round("Дима","Паша");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerNotExistTest() {
        Player pasha = new Player(1, "Паша", 100);
        Game game = new Game();

        game.register(pasha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Саша", "Паша")
        );
    }


    @Test
    void whenSecondPlayerNotExistTest() {
        Player pasha = new Player(1, "Паша", 100);
        Game game = new Game();

        game.register(pasha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Паша", "Саша")
        );
    }

}