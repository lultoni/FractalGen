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
        drawCircleFractal(g, 3);
    }

    public void drawSomething(Graphics g){
        //Rekursive Methode zum Zeichnen auf dem Panel
        int offset = 10;
        for (int i = 0; i < 10; i++) {
            g.drawRect(i * offset + offset,i * offset + offset,offset * i,offset * i);
        }
    }

    public void drawCircleFractal(Graphics g, int amount) {
        if (amount == 0) return;
        int offset = 10;
        int wh = (int) (400 / Math.pow(2, amount - 1));
        int pos = amount; // TODO change position of all circles (div val of wh?)
        // TODO offset has to combine offset + wh/2 or wh
        if (amount == 1) {
            g.drawOval(offset, offset, wh, wh);
        } else {
            g.drawOval(wh/2 + offset, 0 + offset, wh, wh);
            drawCircleFractal(g, amount - 1);
            g.drawOval(0 + offset, wh/2 + offset, wh, wh);
            drawCircleFractal(g, amount - 1);
            g.drawOval(wh + offset, wh/2 + offset, wh, wh);
            drawCircleFractal(g, amount - 1);
            g.drawOval(wh/2 + offset, wh + offset, wh, wh);
            drawCircleFractal(g, amount - 1);
        }
    }
}
