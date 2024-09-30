package projects.ticTacToe;

// java -cp bin projects.ticTacToe.Game



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {

    private JButton[] buttons = new JButton[9];
    private int turn = 0;
    private String currentPlayer = "X";

    Game() {
        JFrame frame = new JFrame("TicTacToe");
        frame.setLayout(new GridLayout(3, 3));
        frame.setSize(640, 680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 100));
            buttons[i].addActionListener(this);
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (!clickedButton.getText().equals("")) {
            return;
        }

        clickedButton.setText(currentPlayer);

        if (checkForWin()) {
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
            resetGame();
        } else if (turn == 8) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetGame();
        } else {
            currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
            turn++;
        }
    }

    private boolean checkForWin() {
        int[][] winningCombinations = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
        };

        for (int[] combination : winningCombinations) {
            if (buttons[combination[0]].getText().equals(currentPlayer) &&
                buttons[combination[1]].getText().equals(currentPlayer) &&
                buttons[combination[2]].getText().equals(currentPlayer)) {
                return true;
            }
        }
        return false;
    }

    private void resetGame() {
        for (JButton button : buttons) {
            button.setText("");
        }
        turn = 0;
        currentPlayer = "X";
    }

    public static void main(String[] args) {
        new Game();
    }
}
