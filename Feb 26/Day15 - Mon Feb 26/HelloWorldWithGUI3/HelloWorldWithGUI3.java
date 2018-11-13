/*
 * HelloWorldWithGUI3.java from Chapter 11
 * The Hello World application with a button in a BoxLayout.
 * Lawrenceville Press
 * June 10, 2005
 */
 
 
import javax.swing.*;
import java.awt.event.*;        

public class HelloWorldWithGUI3 implements ActionListener {
	final static String LABEL_TEXT = "Hello, world!";
	JFrame frame;
	JPanel contentPane;
	JLabel label;
	JButton button;

    public HelloWorldWithGUI3(){
        /* Create and set up the frame */
        frame = new JFrame("HelloWorldWithGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane with a BoxLayout and empty borders */
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
		/* Create and add label that is centered and has empty borders */
	    label = new JLabel(LABEL_TEXT);
	    label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    label.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
	    contentPane.add(label);

		/* Create and add button that is centered */
        button = new JButton("Hide");
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setActionCommand("Hide");
    	button.addActionListener(this);
    	contentPane.add(button);

		/* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }
    
    
    /**
     * Handle button click action event
     * pre: none
     * post: Clicked button has different text and label
     * displays message depending on when the button was clicked.
     */
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        
        if (eventName.equals("Hide")) {
        	label.setText(" ");
        	button.setText("Show");
        	button.setActionCommand("Show");
        } else {
        	label.setText(LABEL_TEXT);
        	button.setText("Hide");
        	button.setActionCommand("Hide");
        }
    }


    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        HelloWorldWithGUI3 greeting = new HelloWorldWithGUI3();
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
