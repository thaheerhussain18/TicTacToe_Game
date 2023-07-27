import java.util.Scanner;

public class TicTacToe {

    private static final char EMPTY = ' ';
    private static final char X_MARK = 'X';
    private static final char O_MARK = 'O';

    private static char[][] board = new char[3][3];
    private static char currentPlayer = X_MARK;

    public static void main(String[] args) {
        startBoard();
        showBoard();

        boolean gameFinished = false;
        while (!gameFinished) {
            int row, col;
            do {
                System.out.print("Player " + currentPlayer + ", enter row (0-2) and column (0-2) separated by space: ");
                Scanner scanner = new Scanner(System.in);
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while (!isMoveValid(row, col));

            board[row][col] = currentPlayer;
            showBoard();

            if (isWinner()) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameFinished = true;
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                gameFinished = true;
            } else {
                currentPlayer = (currentPlayer == X_MARK) ? O_MARK : X_MARK;
            }
        }
    }

    private static void startBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void showBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    private static boolean isMoveValid(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid input! Row and column must be between 0 and 2.");
            return false;
        } else if (board[row][col] != EMPTY) {
            System.out.println("Cell already occupied! Try again.");
            return false;
        }
        return true;
    }

    private static boolean isWinner() {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            // Check columns
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
