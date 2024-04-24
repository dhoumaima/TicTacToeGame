import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class TestWithMock {
    TicTacToe Ticmock;

    @Before
    public void setup() {
        // Créer un mock pour TicTacToe
        Ticmock = mock(TicTacToe.class);
        char[][] board = new char[][] {
            {'X', 'X', 'X'},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};
        // Définir le comportement stubbed pour TheWinner sur le mock
        when(Ticmock.TheWinner(board, 'X')).thenReturn(true);
    }

    @Test
    public void TheWinnerTest() {
        // Utiliser le mock dans le test
        char[][] board = new char[][] {
            {'O', 'X', 'X'},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};
        // Appeler la méthode à tester avec le mock
        Assert.assertEquals("You win :)\n", Ticmock.isGameFinish(board));
        System.out.println("True");
    }
}
