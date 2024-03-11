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
                drawSquareFractal(g, 1, amount, 400, 10, 10, 410, 10, 410, 410, 10, 410);
                updateFractal(amount);
            }
        }
    }

    private void drawSquareFractal(Graphics g, int amount, int max_amount, int lengthSide, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if (amount > max_amount) return;

        int offset = 10 * amount;

        if (amount == 1) {
            lengthSide = 400;
        } else {
            lengthSide = (int) Math.sqrt(Math.pow((double) lengthSide / 10, 2) + Math.pow(9 * ((double) lengthSide / 10), 2));

            int ox1 = x1;
            x1 = x1 + lengthSide / 10;
            y1 = y1 + (int) Math.sqrt(Math.pow((double) lengthSide / 10, 2) - Math.pow(x1 - ox1, 2));

            int oy2 = y2;
            y2 = y2 + lengthSide / 10;
            x2 = x2 - (int) Math.sqrt(Math.pow((double) lengthSide / 10, 2) - Math.pow(y2 - oy2, 2));

            int ox3 = x3;
            x3 = x3 - lengthSide / 10;
            y3 = y3 - (int) Math.sqrt(Math.pow((double) lengthSide / 10, 2) - Math.pow(ox3 - x3, 2));

            int oy4 = y4;
            y4 = y4 - lengthSide / 10;
            x4 = x4 + (int) Math.sqrt(Math.pow((double) lengthSide / 10, 2) - Math.pow(oy4 - y4, 2));
        }

        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x4, y4);
        g.drawLine(x4, y4, x1, y1);
        drawSquareFractal(g, amount + 1, max_amount, lengthSide, x1, y1, x2, y2, x3, y3, x4, y4);
    }

    private void drawHexFractal(Graphics g, int amount, int max_amount) {
        if (amount > max_amount) return;
        double div_out = (double) amount /max_amount;
        int offset = (int) (230 * (1 - div_out + 0.1));

        int lengthSide = 250 - offset;

        int x6 = 0;
        int y6 = (int) (lengthSide / 1.153846);

        int x1 = lengthSide / 2;
        int y1 = 0;

        int x2 = x1 + lengthSide;

        int x3 = lengthSide * 2;

        int x4 = (int) (lengthSide * 1.5);
        int y4 = y6 * 2;

        int[] xPoints = new int[]{x1, x2, x3, x4, x1, x6};
        int[] yPoints = new int[]{y1, y1, y6, y4, y4, y6};
        for (int i = 0; i < xPoints.length; i++) xPoints[i] = xPoints[i] + offset;
        for (int i = 0; i < yPoints.length; i++) yPoints[i] = yPoints[i] + offset * 2;
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
