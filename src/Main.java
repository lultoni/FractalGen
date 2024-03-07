import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        // TODO dropdown menu for different types of fractals (parameter in FractalPanel class)
        String cbList[] = {"Circles", "Hexagons", "Squares"};
        JComboBox dropDownMenu = new JComboBox(cbList);

        controlPanel.add(amountControl);

        dropDownMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                FractalPanel.setCurrentFractal(String.valueOf(dropDownMenu.getSelectedItem()));
            }
        });

        FractalPanel fp = new FractalPanel(amountControl.getAmount());
        amountControl.setFractalPanel(fp);

        mn.add(selectPnl, BorderLayout.SOUTH);
        selectPnl.add(dropDownMenu);
        selectPnl.add(controlPanel);
        mn.add(fp);
    }

}
