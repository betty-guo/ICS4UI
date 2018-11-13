import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HouseDemo extends JFrame 
    implements ActionListener {

    private JButton button;
    private JPanel panel;

    public static void main(String[] args) {
        HouseDemo frame = new HouseDemo();//creats object of type HouseDemo
        frame.setSize(350, 300);//executes setSize for object frame of class HouseDemo
        frame.createGUI();//executes createGUI
        frame.show();//shows screen
    }

    private void createGUI() {//method for creating output on screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);//exit method on close
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );//?

        panel = new JPanel();//creates new panel
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.white);
        window.add(panel);//add panel to window

        button = new JButton("Press me");//creates button
        window.add(button);//add to window
        button.addActionListener(this);//adds action listener
    }
    public void actionPerformed(ActionEvent event) {//draws things on screen
        Graphics paper = panel.getGraphics();

        drawHouse(paper, 10, 20, 70, 20);
        drawHouse(paper, 10, 90, 50, 50);
    }

    private void drawHouse(Graphics drawingArea,//draws houses
        int topRoofX,
        int topRoofY,
        int width,
        int height) {

        drawTriangle(drawingArea, topRoofX, topRoofY, width, height);
        drawingArea.drawRect(topRoofX, 
        topRoofY + height, width, height);

    }

    private void drawTriangle(Graphics drawingArea, //draws triangle
                              int xPlace,
                              int yPlace,
                              int width,
                              int height) {

        drawingArea.drawLine(xPlace, yPlace,
            xPlace, yPlace + height);
        drawingArea.drawLine(xPlace, yPlace + height,
            xPlace + width, yPlace + height);
        drawingArea.drawLine(xPlace, yPlace,xPlace + width,
            yPlace + height);
    }
}

