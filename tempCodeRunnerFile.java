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