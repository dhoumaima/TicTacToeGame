import java.util.Random;
import java.util.Scanner;
public class TicTacToe
{
    public static void main(String[] args)
    {
        String msg1="You win :)\n";
        String msg2="The Computer Win :(\n";
        //creer la board
        char[][] board={{' ',' ',' '},
                        {' ',' ',' '},
                         {' ',' ',' '}};
        printBoard(board);//pour afficher la board vide
        //l'utilisateur va choisi
        while (true) 
        {
        playerMove(board);//le joueur va jouer avec "X"
        printBoard(board);
        if (msg1.equals(isGameFinish(board))|| msg2.equals(isGameFinish(board)))//on va tester si la jeu a fini apres chaque mouvement 
        {
            System.out.println(isGameFinish(board));
            break;   
        }
        //pour que le computer chosie sa position
        ComputerMove(board);//l'ordinateur va jouer avec "O"
       printBoard(board);//l'affichage de board aprés la modification
       if (msg1.equals(isGameFinish(board))|| msg2.equals(isGameFinish(board)))
        {
            System.out.println(isGameFinish(board));
            break;   
        }
        }
    }
    //une methode pou tester s'il ya un gagnant
    public static boolean TheWinner(char[][] board,char c)
    {
        if((board[0][0]==c&& board[0][1]==c&& board[0][2]==c)||
        (board[1][0]==c && board[1][1]==c && board[2][2]==c)||
        (board[2][0]==c && board[2][1]==c && board[2][2]==c)||

        (board[0][0]==c && board[1][0]==c && board[2][0]==c)||
        (board[0][1]==c && board[1][1]==c && board[2][1]==c)||
        (board[0][2]==c && board[1][2]==c && board[2][2]==c)||

        (board[0][0]==c && board[1][1]==c && board[2][2]==c)||
        (board[0][2]==c && board[1][1]==c && board[2][0]==c))
        {   
            
            return true;
        }
        else
        {
            return false;
        }
    }
    //une methode pour tester si la jeu est terminer ou non 
    public static String isGameFinish(char[][] board) {
        // Les tests pour le joueur
        if (TheWinner(board, 'X')) {
            return "You win :)\n" ;
          
        }
    
        // Les tests pour l'ordinateur
        if (TheWinner(board, 'O')) {
            return "The Computer Win :(\n" ;
           
        }
        return "The game is over.";
    }
//une methode pour que la machine choisi une position aleatoire
    public static void ComputerMove(char[][] board) {
        Random rand =new Random();
        int computerMove;
        while (true) 
        {
            computerMove=rand.nextInt(9)+1;
            if(isValidMove(board,Integer.toString(computerMove) ))
            {
                break;
            }
        }
        System.out.println("computer position: "+computerMove);
        placeMove(board,Integer.toString(computerMove),'O');
    }
//une methode pour virifier si le joueur a choisi cette case ou non
//si oui return false sinon true
    public static boolean isValidMove(char[][] board,String position)
    {
        switch (position) {
            case "1":
                return(board[0][0]==' ');
            case "2":
               return(board[0][1]==' ') ;
               
            case "3":
                return(board[0][2]==' ');
                
            case "4":
               return(board[1][0]==' ');
                
            case "5":
                return(board[1][1]==' ');
                
            case "6":
                return(board[1][2]==' ');
                
            case "7":
                return(board[2][0]==' ');
                
            case "8":
                return(board[2][1]==' ');
                
            case "9":
                return(board[2][2]==' ');
                
            default:
                return false;
        }
    }
//une methode pour lire la position choisi par l'utilisateur
    public static void playerMove(char[][] board) {
        while (true) {
            System.out.println("Where would you like to play?(1-9)");
            Scanner scanner=new Scanner(System.in);
            String userInput=scanner.nextLine();
            if (isValidMove(board, userInput)) 
            {
                placeMove(board,userInput,'X');
                break;
            }
            else
            {
                System.out.println(userInput+" is not a valide move");
            }
        }
        
        
        
    }
//une methode pour vérifier si cette position est disponible ou non.
    public static void placeMove(char[][] board,String position, char symbol) {
       
        switch (position) {
            case "1":
                board[0][0]=symbol;
                break;
            case "2":
                board[0][1]=symbol;
                break;
            case "3":
                board[0][2]=symbol;
                break;
            case "4":
                board[1][0]=symbol;
                break;
            case "5":
                board[1][1]=symbol;
                break;
            case "6":
                board[1][2]=symbol;
                break;
            case "7":
                board[2][0]=symbol;
                break;
            case "8":
                board[2][1]=symbol;
                break;
            case "9":
                board[2][2]=symbol;
                break;
            default:
                System.out.println(":(");
                break;
        }
    }
//une methode pour afficher la board.
    public static void printBoard(char[][] board) {
        System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
    }
}
 }
}
