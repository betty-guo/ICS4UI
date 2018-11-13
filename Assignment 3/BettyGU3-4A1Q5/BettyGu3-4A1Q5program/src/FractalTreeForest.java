import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class FractalTreeForest extends JFrame {

    Random randgen = new Random();

    public FractalTreeForest() {
        super("Fractal Tree Forest");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        FractalTreePanel panel = new FractalTreePanel();
        JPanel panel1 = new JPanel();
        panel1.setBounds(100, 100, 800, 2);
        panel1.setLayout(new FlowLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        JLabel label = new JLabel("Welcome to Fractal Forest! By planting trees, you can turn this empty screen into a beautiful monoculture fractal tree farm!");
        JLabel label1 = new JLabel("The recursive depth of each tree is randomly generated. Have fun!");

        JButton button1 = new JButton("Plant!");
        button1.addActionListener(e -> {
            int n = randgen.nextInt(800);
            int d = randgen.nextInt(10) +4;
            panel.drawTree(n, 500, -90, d);
            panel.repaint();
        });
        panel1.add(button1);
        panel1.setMinimumSize(new Dimension(50, 25));
        panel1.setPreferredSize(new Dimension(50, 25));
        panel1.setMaximumSize(new Dimension(50, 25));
        add(panel1);
        add(panel);
        panel2.add(label);
        panel2.add(label1);
        panel2.setMinimumSize(new Dimension(800, 50));
        panel2.setPreferredSize(new Dimension(800, 50));
        panel2.setMaximumSize(new Dimension(800, 50));
        add(panel2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        FractalTreeForest frame = new FractalTreeForest();
        frame.setVisible(true);
    }
}