package Day1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlappyBird extends JFrame implements ActionListener, KeyListener {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private static final int GROUND_HEIGHT = 50;

    private Timer timer;
    private int birdY;
    private int birdVelocity;
    private int gravity;
    private boolean isJumping;

    private List<Rectangle> pipes;
    private int pipeWidth;
    private int pipeHeight;
    private int pipeGap;
    private int pipeDistance;
    private Random random;

    private int score;

    private boolean isGameOver;

    public FlappyBird() {
        setTitle("Flappy Bird");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        birdY = HEIGHT / 2;
        birdVelocity = 0;
        gravity = 2;
        isJumping = false;

        pipes = new ArrayList<>();
        pipeWidth = 100;
        pipeHeight = 400;
        pipeGap = 200;
        pipeDistance = 300;
        random = new Random();

        score = 0;

        isGameOver = false;

        timer = new Timer(20, this);
        timer.start();

        addKeyListener(this);
        setFocusable(true);
        initializePipes();
    }

    private void initializePipes() {
        pipes.clear();
        for (int i = 0; i < 3; i++) {
            int pipeX = WIDTH + i * (pipeDistance + pipeWidth);
            int pipeHeight = random.nextInt(400) + 100; // Random height for pipes
            pipes.add(new Rectangle(pipeX, 0, pipeWidth, pipeHeight));
            pipes.add(new Rectangle(pipeX, pipeHeight + pipeGap, pipeWidth, HEIGHT - GROUND_HEIGHT - pipeHeight - pipeGap));
        }
    }

    private void restartGame() {
        birdY = HEIGHT / 2;
        birdVelocity = 0;
        score = 0;
        isGameOver = false;
        initializePipes();
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlappyBird game = new FlappyBird();
            game.setVisible(true);
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.orange);
        g.fillRect(200, birdY, 50, 50); // Bird

        g.setColor(Color.green);
        for (Rectangle pipe : pipes) {
            g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
        }

        g.setColor(Color.red);
        g.fillRect(0, HEIGHT - GROUND_HEIGHT, WIDTH, GROUND_HEIGHT); // Ground

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("Score: " + score, 20, 30);

        if (isGameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 60));
            g.drawString("Game Over", WIDTH / 2 - 200, HEIGHT / 2 - 30);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            if (isJumping) {
                birdVelocity = -20;
                isJumping = false;
            }

            birdVelocity += gravity;
            birdY += birdVelocity;

            updatePipes();

            checkCollision();

            score++;
        }

        repaint();
    }

    private void updatePipes() {
        for (Rectangle pipe : pipes) {
            pipe.x -= 5; // Move pipes to the left

            if (pipe.x + pipe.width < 0) {
                // If the pipe is out of the screen, reset its position
                pipe.x = WIDTH;
                if (pipes.indexOf(pipe) % 2 == 0) {
                    pipe.height = random.nextInt(400) + 100;
                }
            }
        }
    }

    private void checkCollision() {
        for (Rectangle pipe : pipes) {
            if (pipe.intersects(new Rectangle(200, birdY, 50, 50)) || birdY >= HEIGHT - GROUND_HEIGHT) {
                isGameOver = true;
                timer.stop();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !isGameOver) {
            isJumping = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER && isGameOver) {
            restartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
