import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AreaMethod extends JFrame //extends JFrame class (can use methods in class)
    implements ActionListener {

    private JButton button;//creates private button to be accessed in all methods
    private JPanel panel;//creates panel to be accessed in all methods

    public static void main(String[] args) {//main method
        AreaMethod frame = new AreaMethod();//creates frame object from AreaMethod class
        frame.setSize(400, 300);//executes setSize method from JFrame, sets size of frame
        frame.createGUI();//executes createGUI from AreaMethod
        frame.show();//executes show method from JFrame
    }

    private void createGUI() {//create GUI method
        setDefaultCloseOperation(EXIT_ON_CLOSE);//exit on close
        Container window = getContentPane();//data type container set equal to getcontentpane
        window.setLayout(new FlowLayout() );//sets layout

        panel = new JPanel();//creates new panel
        panel.setPreferredSize(new Dimension(300, 200));//sets size for panel
        panel.setBackground(Color.orange);
        window.add(panel);//add panel to window

        button = new JButton("Press me");//creates button
        window.add(button);
        button.addActionListener(this);//adds action listener. if pressed executes actionperformed
    }
    public void actionPerformed(ActionEvent event) {//intitialize actionPerformed method from ActionListener
        int a;    
        a = areaRectangle(10, 20);//executes areaRectangle and stores returned value in a
        JOptionPane.showMessageDialog(null, "Area is:  " + a);//print output onto JOptionPane
    }

    private int areaRectangle(int length, int width) {//rectangle area method
        int area;
        area = length * width;
        return area;
    }
}

 
 


