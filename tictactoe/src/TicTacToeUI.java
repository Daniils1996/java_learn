import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


import java.util.Random;

public class TicTacToeUI extends JFrame {
    JButton[][] buttons = new JButton[3][3];
    boolean xTurn = true;

    public TicTacToeUI() {
        super("Tic Tac Toe");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j] = button;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (xTurn) {
                            button.setText("X");
                        } else {
                            button.setText("O");
                        }
                        button.setEnabled(false);
                        checkForWin();
                        xTurn = !xTurn;
                    }
                });
                add(button);
            }
        }

        setVisible(true);
    }

    private void checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][1].getText().equals(buttons[i][2].getText()) && !buttons[i][0].getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Player " + buttons[i][0].getText() + " wins!");
                resetGame();
                return;
            }
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[1][i].getText().equals(buttons[2][i].getText()) && !buttons[0][i].getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Player " + buttons[0][i].getText() + " wins!");
                resetGame();
                return;
            }
        }
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Player " + buttons[0][0].getText() + " wins!");
            resetGame();
            return;
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText()) && !buttons[0][2].getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Player " + buttons[0][2].getText() + " wins!");
            resetGame();
            return;
        }
        checkForDraw();
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        xTurn = true;
    }

    private void checkForDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].isEnabled()) {
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Game Drawn!");
        resetGame();
    }

    public static void main(String[] args) {
        TicTacToeUI game = new TicTacToeUI();
    }
}

