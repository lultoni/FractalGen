import javax.swing.*;
import java.awt.*;

public class FractalPanel extends JPanel {

    private int amount;
    public static String currentFractal;

    public FractalPanel(int amount){
        currentFractal = "Circles";
        this.amount = amount;
        setBackground(Color.white);
    }

    //starts automatically when adding Panel to Frame
    //or call fractalPanel.repaint() in JFrame-Class
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (currentFractal) {
            case "Circles" -> {
                updateFractal(AmountControl.getAmount());
                drawCircleFractal(g, 1, amount, 10, 10);
            }
            case "Hexagons" -> {
                updateFractal(AmountControl.getAmount());
                drawHexFractal(g, 1, amount, 10, 10);
            }
            case "Squares" -> {
                updateFractal(AmountControl.getAmount());
                drawSquareFractal(g, 1, amount, 10, 10);
            }
        }
    }

    private void drawSquareFractal(Graphics g, int i, int amount, int i1, int i2) {
    }

    private void drawHexFractal(Graphics g, int i, int amount, int i1, int i2) {
    }

    public void drawSomething(Graphics g){
        //Rekursive Methode zum Zeichnen auf dem Panel
        int offset = 10;
        for (int i = 0; i < 10; i++) {
            g.drawRect(i * offset + offset,i * offset + offset,offset * i,offset * i);
        }
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
    public static String getCurrentFractal() {
        return currentFractal;
    }
    public static void setCurrentFractal(String x) {
        currentFractal = x;
    }
}

