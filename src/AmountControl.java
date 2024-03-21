import javax.swing.*;
import java.awt.*;

public class AmountControl extends JPanel {

    private int amount;
    private FractalPanel panel;

    JButton plusButton = new JButton("+");
    JLabel amountLabel = new JLabel(getAmountText());
    JButton minusButton = new JButton("-");

    public AmountControl(FractalPanel panel) {
        amount = 1;
        this.panel = panel;
        init();
    }

    private void init() {
        setLayout(new GridLayout());

        plusButton.addActionListener(e -> {
            amount++;
            baseButtonAction();
        });

        minusButton.addActionListener(e -> {
            amount--;
            baseButtonAction();
        });

        add(plusButton);
        add(amountLabel);
        add(minusButton);
    }

    private String getAmountText() {
        return String.valueOf(amount);
    }

    public int getAmount() {
        return amount;
    }

    public void setFractalPanel(FractalPanel fractalPanel) {
        this.panel = fractalPanel;
    }

    private void baseButtonAction() {
        minusButton.setEnabled(amount > 0);
        plusButton.setEnabled(!(panel.currentFractal.equals("Squares") && amount >= 10));
        amountLabel.setText(getAmountText());
        revalidate();
        repaint();
        panel.updateFractal(amount);
    }

}
