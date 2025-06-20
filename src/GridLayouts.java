import javax.swing.*;
import java.awt.*;

public class GridLayouts {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GridLayouts().createAndShowGUI());
    }

    private void createAndShowGUI() {
        // Create JFrame
        JFrame frame = new JFrame("Flag of Nepal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);  // Set window size

        // Create JPanel to draw the flag
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawNepalFlag(g);
            }
        };

        // Add JPanel to the frame
        frame.add(panel);

        // Set frame to be visible
        frame.setVisible(true);
    }

    private void drawNepalFlag(Graphics g) {
        // Set color for the flag background (red)
        g.setColor(new Color(206, 17, 38));  // Nepal's flag red color
        g.fillPolygon(new int[]{50, 250, 50}, new int[]{50, 50, 250}, 3); // Upper triangle
        g.fillPolygon(new int[]{50, 250, 50}, new int[]{250, 250, 450}, 3); // Lower triangle

        // Draw the moon in the upper triangle (circular crescent)
        g.setColor(Color.WHITE);
        g.fillOval(100, 90, 60, 60); // Full moon
        g.setColor(new Color(206, 17, 38)); // Red color for the crescent
        g.fillArc(115, 90, 60, 60, 0, 180); // Crescent (red part)

        // Draw the 12-pointed sun in the lower triangle
        drawSun(g, 150, 350);
    }

    private void drawSun(Graphics g, int centerX, int centerY) {
        g.setColor(Color.WHITE);

        // Draw 12 rays (circle plus rays)
        for (int i = 0; i < 12; i++) {
            double angle = Math.toRadians(i * 30); // 12 rays, 360 / 12 = 30 degrees apart
            int x1 = (int) (centerX + Math.cos(angle) * 50);
            int y1 = (int) (centerY + Math.sin(angle) * 50);
            int x2 = (int) (centerX + Math.cos(angle) * 70);
            int y2 = (int) (centerY + Math.sin(angle) * 70);
            g.drawLine(x1, y1, x2, y2); // Draw each ray
        }

        // Draw the sun's center circle
        g.fillOval(centerX - 20, centerY - 20, 40, 40); // Sun's center
    }
}
