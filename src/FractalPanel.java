import javax.swing.*;
import java.awt.*;

public class FractalPanel extends JPanel {

    private int amount;
    public String currentFractal;

    public FractalPanel(int amount){
        currentFractal = "Circles";
        this.amount = amount;
        setBackground(Color.white);
    }

    public void setCurrentFractal(String s) {
        currentFractal = s;
    }

    //starts automatically when adding Panel to Frame
    //or call fractalPanel.repaint() in JFrame-Class
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (currentFractal) {
            case "Circles" -> {
                drawCircleFractal(g, 1, amount, 10, 10);
                updateFractal(amount);
            }
            case "Hexagons" -> {
                drawHexFractal(g, 1, amount);
                updateFractal(amount);
            }
            case "Squares" -> {
                drawSquareFractal(g, 1, amount, 10, 10);
                updateFractal(amount);
            }
        }
    }

    private void drawSquareFractal(Graphics g, int i, int amount, int i1, int i2) {
    }

    private void drawHexFractal(Graphics g, int amount, int max_amount) {
        if (amount > max_amount) return;
        int offset = amount * 10;

        int x1 = 100;
        int y1 = 50;

        int x2 = 220;
        int y2 = 50;

        int x3 = 270;
        int y3 = 150;

        int x4 = 220;
        int y4 = 250;

        int x5 = 100;
        int y5 = 250;

        int x6 = 50;
        int y6 = 150;

        int[] xPoints = new int[]{x1, x2, x3, x4, x5, x6};
        int[] yPoints = new int[]{y1, y2, y3, y4, y5, y6};
        for (int i = 0; i < xPoints.length; i++) xPoints[i] = xPoints[i] * 1 + offset;
        g.drawPolygon(xPoints, yPoints, 6);
        drawHexFractal(g, amount + 1, max_amount);
    }

    public void drawCircleFractal(Graphics g, int amount, int max_amount, int offset_x, int offset_y) {
        if (amount > max_amount) return;
        int wh = (int) (500 / Math.pow(2, amount - 1));
        if (amount == 1) {
            g.drawOval(offset_x, offset_y, wh, wh);
            drawCircleFractal(g, amount + 1, max_amount, offset_x, offset_y);
        } else {
            g.drawOval(wh/2 + offset_x, offset_y, wh, wh);
            drawCircleFractal(g, amount + 1, max_amount, wh/2 + offset_x, offset_y);

            g.drawOval(offset_x, wh/2 + offset_y, wh, wh);
            drawCircleFractal(g, amount + 1, max_amount, offset_x, wh/2 + offset_y);

            g.drawOval(wh + offset_x, wh/2 + offset_y, wh, wh);
            drawCircleFractal(g, amount + 1, max_amount, wh + offset_x, wh/2 + offset_y);

            g.drawOval(wh/2 + offset_x, wh + offset_y, wh, wh);
            drawCircleFractal(g, amount + 1, max_amount, wh/2 + offset_x, wh + offset_y);
        }
    }

    public void updateFractal(int a) {
        amount = a;
        revalidate();
        repaint();
    }
}
