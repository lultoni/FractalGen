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
        JTextField jtf = new JTextField("400");
        jtf.addActionListener(e -> {
            if (dropDownMenu.getSelectedItem().equals("Squares")) {
                jtf.setEnabled(false);
                jtf.setText("400");
            } else {
                jtf.setEnabled(true);
            }
            for (int i = 0; i < jtf.getText().length(); i++) {
                if (String.valueOf(jtf.getText().charAt(i)).equals("0") || String.valueOf(jtf.getText().charAt(i)).equals("1") || String.valueOf(jtf.getText().charAt(i)).equals("2") || String.valueOf(jtf.getText().charAt(i)).equals("3") || String.valueOf(jtf.getText().charAt(i)).equals("4") || String.valueOf(jtf.getText().charAt(i)).equals("5") || String.valueOf(jtf.getText().charAt(i)).equals("6") || String.valueOf(jtf.getText().charAt(i)).equals("7") || String.valueOf(jtf.getText().charAt(i)).equals("8") || String.valueOf(jtf.getText().charAt(i)).equals("9")) {

                } else {
                    jtf.setText("400");
                }
            }
            fp.sideLength = Integer.valueOf(jtf.getText());
            mn.revalidate();
            mn.repaint();
        });
        dropDownMenu.addActionListener(e -> {
            fp.setCurrentFractal(String.valueOf(dropDownMenu.getSelectedItem()));
            if (dropDownMenu.getSelectedItem().equals("Squares")) {
                jtf.setEnabled(false);
                jtf.setText("400");
                fp.sideLength = Integer.valueOf(jtf.getText());
            } else {
                jtf.setEnabled(true);
            }
            if (dropDownMenu.getSelectedItem().equals("Fractal Tree")) {
                jtf.setText("100");
                fp.sideLength = Integer.valueOf(jtf.getText());
            }
            if (dropDownMenu.getSelectedItem().equals("Hexagons")) {
                jtf.setText("200");
                fp.sideLength = Integer.valueOf(jtf.getText());
            }
            if (dropDownMenu.getSelectedItem().equals("Circles")) {
                jtf.setText("400");
                fp.sideLength = Integer.valueOf(jtf.getText());
            }
            mn.revalidate();
            mn.repaint();
        });
        amountControl.setFractalPanel(fp);

        mn.add(selectPnl, BorderLayout.SOUTH);
        selectPnl.add(dropDownMenu);
        selectPnl.add(controlPanel);
        selectPnl.add(jtf);
        mn.add(fp);

        mn.revalidate();
        mn.repaint();
    }

}
