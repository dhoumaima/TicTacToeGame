import java.util.Random;
import java.util.Scanner;
public class TicTacToe
{
    public static void main(String[] args)
    {
        //creer la board
        char[][] board={{' ',' ',' '},
                        {' ',' ',' '},
                         {' ',' ',' '}};
        printBoard(board);//pour afficher la board vide
        //l'utilisateur va choisi
        while (true) 
        {
        playerMove(board);
        printBoard(board);
        //pour que le computer chosie sa position
        ComputerMove(board);
        //l'affichage de board aprés la modification
       printBoard(board);
        }
    }
//une methode pour que la machine choisi une position aleatoire
    private static void ComputerMove(char[][] board) {
        Random rand =new Random();
        int computerMove;
        while (true) 
        {
            computerMove=rand.nextInt(9)+1;
            if(isValidMove(board, computerMove))
            {
                break;
            }
        }
        System.out.println("computer position: "+computerMove);
        placeMove(board,Integer.toString(computerMove),'O');
    }
//une methode pour virifier si le joueur a choisi cette case ou non
//si oui return false sinon true
    private static boolean isValidMove(char[][] board,int position)
    {
        switch (position) {
            case 1:
                return(board[0][0]==' ');
            case 2:
               return(board[0][1]==' ') ;
               
            case 3:
                return(board[0][2]==' ');
                
            case 4:
               return(board[1][0]==' ');
                
            case 5:
                return(board[1][1]==' ');
                
            case 6:
                return(board[1][2]==' ');
                
            case 7:
                return(board[2][0]==' ');
                
            case 8:
                return(board[2][1]==' ');
                
            case 9:
                return(board[2][2]==' ');
                
            default:
                return false;
        }
    }
//une methode pour lire la position choisi par l'utilisateur
    private static void playerMove(char[][] board) {
        System.out.println("Where would you like to play?(1-9)");
        Scanner scanner=new Scanner(System.in);
        String userInput=scanner.nextLine();
        if (isValidMove(board, userInput) )
        {
            placeMove(board,userInput,'X');
        }
        
    }
//une methode pour vérifier si cette position est disponible ou non.
    private static void placeMove(char[][] board,String position, char symbol) {
       
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
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
    }
}