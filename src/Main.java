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
        JPanel selectPnl = new JPanel();

        JPanel controlPanel = new JPanel();
        AmountControl amountControl = new AmountControl(null);

        String[] cbList = {"Circles", "Hexagons", "Squares", "Fractal Tree"};
        JComboBox dropDownMenu = new JComboBox(cbList);

        controlPanel.add(amountControl);

        FractalPanel fp = new FractalPanel(amountControl.getAmount());
        dropDownMenu.addActionListener(e -> fp.setCurrentFractal(String.valueOf(dropDownMenu.getSelectedItem())));
        amountControl.setFractalPanel(fp);

        mn.add(selectPnl, BorderLayout.SOUTH);
        selectPnl.add(dropDownMenu);
        selectPnl.add(controlPanel);
        mn.add(fp);

        mn.revalidate();
        mn.repaint();
    }

}
