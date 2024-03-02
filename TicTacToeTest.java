import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;
public class TicTacToeTest {

    @Test
    //cette methode pour tester la methode placeMove
    public void placeMoveTest()
    {
        // Créez une instance de la classe TicTacToe
        TicTacToe tic=new TicTacToe();
        char[][] board = new char[][] 
        {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
      // Appelez la méthode placeMove avec différentes positions
      tic.placeMove(board, "1", 'X');  
      assertEquals('X',board[0][0]);
      //tester une position invalide
      tic.placeMove(board, "11", 'X');
      //ici un message ":(" va être afficher 
    }
    @Test
    public void testPlayerMove() {
        TicTacToe ticTacToe = new TicTacToe();

        // Créez un tableau représentant le plateau
        char[][] board = new char[][] {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        // Configurez le mock pour la saisie utilisateur simulée
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(inputStream);

        // Configurez le mock pour capturer la sortie console
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Appelez la méthode playerMove
        ticTacToe.playerMove(board);
        // Restaurez les flux d'entrée/sortie standard
        System.setIn(System.in);
        System.setOut(System.out);
    }
    @Test
    public void isValidMoveTest()
    {
        // Créez un tableau représentant le plateau
        
        char[][] board = new char[][] {
            {' ', 'O', 'X'},
            {'O', ' ', 'O'},
            {'X', 'O', 'X'}
    };

    // Testez différentes positions sur le plateau
    assertTrue(TicTacToe.isValidMove(board, "1"));
    assertFalse(TicTacToe.isValidMove(board, "2"));
    assertTrue(TicTacToe.isValidMove(board, "5"));
    assertFalse(TicTacToe.isValidMove(board, "9"));

    // Testez une position invalide
    assertFalse(TicTacToe.isValidMove(board, "10"));
    //testez si la postion n'est pas un nombre
    assertFalse(TicTacToe.isValidMove(board, "nnnnn"));
}
@Test
public void testIsGameFinish() {
    // Créez un tableau représentant le plateau
    char[][] board = new char[][] {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'X', 'O', 'X'}
    };

    // Testez différents états du jeu
    assertEquals("You win :)\n" , TicTacToe.isGameFinish(board));
    char[][] board1 = new char[][] {
        {'X', 'O', 'X'},
        {'O', 'O', 'O'},
        {'X', 'X', 'O'}};
    assertEquals("The Computer Win :(\n", TicTacToe.isGameFinish(board1));
    char[][] board2 = new char[][] {
        {'X', 'X', 'O'},
        {'O', 'X', 'X'},
        {'X', 'O', 'O'}};
    assertEquals( "The game is over.", TicTacToe.isGameFinish(board2));
    
}
}
