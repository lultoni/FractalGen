import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        init();
    }

    private void init() {
        setTitle("FractalGen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(5, 5, 500, 500);
        setVisible(true);
    }

    public static void main (String[] args) {
        Main mn = new Main();
        FractalPanel fp = new FractalPanel();
        mn.add(fp);
    }

}
