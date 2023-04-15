import java.util.Random;

public class AI {
    private char[][] board;
    private Random rand = new Random();

    public AI(char[][] board) {
        this.board = board;
    }

    public void getAiInput() {
        int row = rand.nextInt(3);
        int col = rand.nextInt(3);
        if (board[row][col] == ' ') {
            board[row][col] = 'O';
        } else {
            getAiInput();
        }
    }
}
