package Day1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

public class HeartAnimation extends JFrame {

    private int x = 0;
    private int y = 150;
    private int yDirection = 1; // 1 for downward, -1 for upward
    private float scaleFactor = 2.0f; // Scale factor for the heart size
    private double velocity = 0; // Initial velocity
    private double gravity = 0.1; // Gravity acceleration

    public HeartAnimation() {
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calculate the new velocity due to gravity
                velocity += gravity;

                // Update the heart's vertical position using the current velocity
                y += (int) velocity;

                // Handle bouncing back when hitting the bottom or top
                if (y <= 0 || y + 100 >= getHeight()) {
                    yDirection *= -1;
                    velocity = -velocity * 0.7; // Elastic collision: velocity after bounce
                }

                // Repaint the frame
                repaint();
            }
        });

        timer.start();

        // Set up the JFrame
        setTitle("Heart Animation");
        setSize(800, 600); // Increased window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw a scaled heart shape
        int scaledWidth = (int) (100 * scaleFactor);
        int scaledHeight = (int) (100 * scaleFactor);

        GeneralPath heartShape = new GeneralPath();
        heartShape.moveTo(x, y + scaledHeight / 2);
        heartShape.quadTo(x, y, x + scaledWidth / 2, y);
        heartShape.quadTo(x + scaledWidth, y, x + scaledWidth, y + scaledHeight / 2);
        heartShape.lineTo(x + scaledWidth / 2, y + scaledHeight);
        heartShape.closePath();

        g2d.setColor(Color.RED);
        g2d.fill(heartShape);

        // Draw stylish text
        g2d.setColor(Color.BLACK);
        Font font = new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 30);
        g2d.setFont(font);
        g2d.drawString("I Love You, PAVI CHELLAM ❤️", getWidth() / 4, getHeight() / 2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HeartAnimation();
            }
        });
    }
}