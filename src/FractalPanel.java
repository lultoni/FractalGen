import javax.swing.*;
import java.awt.*;

public class FractalPanel extends JPanel {

    public FractalPanel(){
        setBackground(Color.white);
    }

    //starts automatically when adding Panel to Frame
    //or call fractalPanel.repaint() in JFrame-Class
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCircleFractal(g, 1, 4, 10, 10);
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
        int wh = (int) (400 / Math.pow(2, amount - 1));
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
}
