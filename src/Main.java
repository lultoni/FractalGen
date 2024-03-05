import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        init();
    }

    private void init() {
        setTitle("FractalGen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(5, 5, 550, 600);
        setVisible(true);
    }

    public static void main (String[] args) {
        Main mn = new Main();
        mn.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        AmountControl amountControl = new AmountControl(null);
        // TODO dropdown menu for different types of fractals (parameter in FractalPanel class)

        controlPanel.add(amountControl);

        FractalPanel fp = new FractalPanel(amountControl.getAmount());
        amountControl.setFractalPanel(fp);

        mn.add(controlPanel, BorderLayout.SOUTH);
        mn.add(fp);
    }

}
