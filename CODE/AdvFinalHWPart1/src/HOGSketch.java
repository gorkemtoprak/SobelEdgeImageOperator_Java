import javax.swing.*;
import java.awt.*;

public class HOGSketch extends JPanel {

    int[][] histogram;
    int width, height;

    public HOGSketch(int width, int height, int[][] histogram) {
        this.histogram = histogram;
        this.width = width;
        this.height = height;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (col % 9 == 0) {
                    g.setColor(Color.RED);
                    g.drawLine(row * 9 + col + 10, 300, row * 9 + col + 10, 250);
                    g.setColor(Color.BLACK);
                }
                g.drawLine(row * 7 + col + 10, 300, row * 5 + col + 10, 300);

            }
            // g.setColor(new Color(pixels[row], pixels[row], pixels[row]));
        }
    }
}
