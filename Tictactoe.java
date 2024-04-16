import java.util.Scanner;

public class Tictactoe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        
        while (!gameOver) {
            int row = 0, col = 0;
            printBoard(board);
            System.out.print("Player " + player + " enter: ");
            int input = sc.nextInt();
            
            switch (input) {
                case 1 -> {row = 0; col = 0;}
                case 2 -> {row = 0; col = 1;}
                case 3 -> {row = 0; col = 2;}
                case 4 -> {row = 1; col = 0;}
                case 5 -> {row = 1; col = 1;}
                case 6 -> {row = 1; col = 2;}
                case 7 -> {row = 2; col = 0;}
                case 8 -> {row = 2; col = 1;}
                case 9 -> {row = 2; col = 2;}
            }

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveWon(board, player);

                if (gameOver) {
                    printBoard(board);
                    System.out.println("player " + player + " has won");
                }  else if (isBoardFull(board)) {
                    gameOver = isBoardFull(board);
                    if (gameOver) {
                        printBoard(board);
                        System.out.println("It's a tie");
                    }
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again");
            }
        }
    }

    public static boolean haveWon(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {      // For row
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < board[0].length; col++) {      // For col
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }

        return false;
    }

    public static void printBoard(char[][] board) {
        System.out.println("+---+---+---+");
        for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("+---+---+---+");
        }
    }

    static boolean isBoardFull(char board[][]) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}