import javax.swing.*;
import java.awt.*;
import java.util.Objects;

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
            String text = jtf.getText();
            boolean isSquareSelected = Objects.equals(dropDownMenu.getSelectedItem(), "Squares");
            if (isSquareSelected) {
                jtf.setEnabled(false);
                jtf.setText("400");
            } else {
                jtf.setEnabled(true);
            }
            if (!isNumeric(text)) {
                jtf.setText("400");
            }
            fp.sideLength = Integer.parseInt(jtf.getText());
            mn.revalidate();
            mn.repaint();
        });

        dropDownMenu.addActionListener(e -> {
            String selectedItem = String.valueOf(dropDownMenu.getSelectedItem());
            fp.setCurrentFractal(selectedItem);
            switch (selectedItem) {
                case "Fractal Tree":
                    jtf.setText("100");
                    break;
                case "Hexagons":
                    jtf.setText("200");
                    break;
                case "Circles":
                    jtf.setText("400");
                    break;
                default: // Squares
                    jtf.setText("400");
                    break;
            }
            jtf.setEnabled(!selectedItem.equals("Squares"));
            fp.sideLength = Integer.parseInt(jtf.getText());
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

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

}
