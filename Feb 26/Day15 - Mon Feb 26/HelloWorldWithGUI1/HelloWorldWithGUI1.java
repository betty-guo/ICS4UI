/*
 * HelloWorldWithGUI1.java from Chapter 11
 * The Hello World application with a GUI.
 * Lawrenceville Press
 * June 10, 2005
 */
 
 
import javax.swing.*;

public class HelloWorldWithGUI1 {
	final static String LABEL_TEXT = "Hello, world!";
	JFrame frame;
	JPanel contentPane;
	JLabel label;

    public HelloWorldWithGUI1(){
        /* Create and set up the frame */
        frame = new JFrame("HelloWorldWithGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane */
        contentPane = new JPanel();

		/* Create and add label */
	    label = new JLabel(LABEL_TEXT);
        contentPane.add(label);

		/* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }
    
    
    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        HelloWorldWithGUI1 greeting = new HelloWorldWithGUI1();
    }


    public static void main(String[] args) {
        /* Methods that create and show a GUI should be 
           run from an event-dispatching thread */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }
}

