import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import static org.mockito.Mickito.*;

public class mockTest  {
    TicTacToe T=new TicTacToe();
    // Méthode de test pour mocker TheWinner et retourner un résultat spécifique
    public void mockTheWinner(boolean result) {
        char[][] board = new char[3][3]; // Créez un tableau de jeu fictif pour le test
        char c = 'X'; // Ou 'O', selon votre besoin de mocker X ou O
        TicTacToe mockedWinner = mock(TicTacToe.class);
        when(mockedWinner.TheWinner(board, c)).thenReturn(result);
    }

    // Test 1 : Vérifiez si le joueur gagne
    @Test
    public void testPlayerWins() {
        mockTheWinner(true); // Mocker TheWinner pour retourner true
        char[][] board = new char[][] 
        {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'X', 'O', 'X'}
        };/* tableau de jeu avec le scénario de victoire du joueur */;
        String result = T.isGameFinish(board);
        assertEquals("You win :)\n", result);
    }

    // Test 2 : Vérifiez si l'ordinateur gagne
    @Test
    public void testComputerWins() {
        mockTheWinner(true); // Mocker TheWinner pour retourner true
        char[][] board = new char[][] {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'X', 'O', 'X'}
    };/* tableau de jeu avec le scénario de victoire de l'ordinateur */;
        String result = T.isGameFinish(board);
        assertEquals("The Computer Win :(\n", result);
    }

    // Test 3 : Vérifiez si le jeu n'est pas terminé
    @Test
    public void testGameNotFinished() {
        mockTheWinner(false); // Mocker TheWinner pour retourner false
        char[][] board = new char[][] {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'X', 'O', 'X'}
    };/* tableau de jeu avec un scénario où personne n'a encore gagné */;
        String result = T.isGameFinish(board);
        assertEquals("The game is over.", result);
    }
}

