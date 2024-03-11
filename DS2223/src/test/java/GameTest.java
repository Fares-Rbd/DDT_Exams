import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {

        game = new Game();
    }

    private void rollMany(int times, int score) {
        for (int i = 0; i < times; i++)
            game.roll(score);
    }

    @Test
    void should_return_0_for_a_gutter_game() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    void should_return_20_for_all_ones() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    void should_return_18_for_spare_followed_by_4(){
        game.roll(7);
        game.roll(3);
        game.roll(4);
        rollMany(17, 0);
        assertEquals(18, game.score());
    }
    @Test
    void should_return_38_for_strike_followed_by_5_then_9(){
        game.roll(10);
        game.roll(5);
        game.roll(9);
        rollMany(17, 0);
        assertEquals(38, game.score());
    }
    @ParameterizedTest
    @CsvSource({"10,9,5,38","10,8,6,38","10,1,1,14","10,0,0,10","10,5,4,28"})
    public void parameterized_test_for_strike(int firstThrow,int secondThrow, int thirdThrow, int result){
        game.roll(firstThrow);
        game.roll(secondThrow);
        game.roll(thirdThrow);
        rollMany(17, 0);
        assertEquals(result, game.score());
    }
}