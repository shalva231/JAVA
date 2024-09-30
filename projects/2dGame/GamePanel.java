import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Player player;
    private Enemy enemy;
    private Puzzle puzzle;
    private boolean isGameOver = false;
    private boolean hasKey = false;

    public GamePanel() {
        setFocusable(true);
        setPreferredSize(new Dimension(800, 600));  // Set game window size
        setBackground(Color.BLACK);
        addKeyListener(this);

        player = new Player(50, 50);
        enemy = new Enemy(400, 300);
        puzzle = new Puzzle(200, 150);  // Simple puzzle like a key to unlock a door

        timer = new Timer(16, this);  // Approximately 60 FPS
    }

    public void startGame() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            player.update();
            enemy.update(player.getX(), player.getY());

            // Check collision between player and puzzle
            if (player.getBounds().intersects(puzzle.getBounds()) && !hasKey) {
                hasKey = true;  // Player picks up the key
                puzzle.setCollected(true);
            }

            // Check collision between player and enemy
            if (player.getBounds().intersects(enemy.getBounds())) {
                isGameOver = true;
            }

            repaint();  // Repaint the game window
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.render(g);
        enemy.render(g);
        puzzle.render(g, hasKey);

        if (isGameOver) {
            g.setColor(Color.RED);
            g.drawString("Game Over! Press R to Restart", 300, 300);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!isGameOver) {
            player.keyPressed(e);
        }

        if (e.getKeyCode() == KeyEvent.VK_R && isGameOver) {
            // Restart the game
            isGameOver = false;
            player = new Player(50, 50);
            enemy = new Enemy(400, 300);
            hasKey = false;
            puzzle.setCollected(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
