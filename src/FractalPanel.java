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
        drawSomething(g);
    }

    public void drawSomething(Graphics g){
        //Rekursive Methode zum Zeichnen auf dem Panel
        g.drawRect(20,20,50,50);
    }
}
