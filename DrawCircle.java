import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class DrawCircle extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    int size = 500;
    double x;
    double y;
    int iterations = 1;
    int amountIn = 0;
    String output;

    public DrawCircle() {
        setSize(size, size);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        amountIn = 0;
	int i = 0;
        g2d.drawOval(0, 0, size, size);
        while (true) {
	    i++;
            g2d.setColor(Color.BLACK);
            x = ((Math.random() * (size)));
            y = ((Math.random() * size));
            if (checkLocation(x, y, size)) {
                g2d.setColor(Color.BLUE);
                amountIn++;
            }
            else
                g2d.setColor(Color.RED);
            g2d.drawLine((int) x, (int) y,(int) x, (int) y);
            double ratio = 4 * ((double)amountIn / iterations);
            //System.out.println(ratio);
            output = ( String.valueOf(ratio));
            g2d.setColor(Color.BLACK);
            g2d.clearRect(0, 0, 200, 55);
            g2d.drawString(output, 10, 50);
	    g2d.clearString(output, 10, 50);
	    g2d.drawString(String.valueOf(i), 0, size);
            iterations++;
        }
    }

    public static boolean checkLocation(double x, double y, int size) {
        boolean isInCircle = false;
        double x1 = x - (size / 2);
        double y1 = y - (size / 2);
        if (Math.sqrt((x1 * x1) + (y1 * y1)) <= size / 2) {
            isInCircle = true;
        }
        return isInCircle;
    }
}
