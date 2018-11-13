/*
 * SemesterAvg.java from Chapter 11
 * Computes the average of the grades entered by the user.
 * Lawrenceville Press
 * June 10, 2005
 */
 
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;        

public class SemesterAvg implements ActionListener {
	JFrame frame;
	JPanel contentPane;
	JLabel prompt1, prompt2, prompt3, average;
	JTextField grade1, grade2, grade3;
	JButton avgButton;
	
    public SemesterAvg(){
        /* Create and set up the frame */
        frame = new JFrame("Semester Average");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane with a GridLayout and empty borders */
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 2, 10, 5));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
		/* Create and add a prompt and then a text field */
	    prompt1 = new JLabel("Enter the first grade: ");
	    contentPane.add(prompt1);
	    
	    grade1 = new JTextField(10);
	    contentPane.add(grade1);

		/* Create and add a second prompt and then a text field */
	    prompt2 = new JLabel("Enter the second grade: ");
	    contentPane.add(prompt2);
	    
	    grade2 = new JTextField(10);
	    contentPane.add(grade2);

		/* Create and add a third prompt and then a text field */
	    prompt3 = new JLabel("Enter the third grade: ");
	    contentPane.add(prompt3);
	    
	    grade3 = new JTextField(10);
	    contentPane.add(grade3);

		/* Create and add button that will display the average of the grades */
        avgButton = new JButton("Average");
        avgButton.setActionCommand("Average");
    	avgButton.addActionListener(this);
    	contentPane.add(avgButton);

		/* Create and add a label that will display the average */
	    average = new JLabel(" ");
	    average.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
	    contentPane.add(average);

		/* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }
    
    
    /**
     * Handle button click action event
     * pre: none
     * post: The average of the grades entered has been calculated and displayed.
     */
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        
        if (eventName.equals("Average")) {
        	double avgGrade;
        	String g1 = grade1.getText();
        	String g2 = grade2.getText();
        	String g3 = grade3.getText();
        	
        	avgGrade = (Double.parseDouble(g1) + Double.parseDouble(g2) + 
        				Double.parseDouble(g3))/3;
        	average.setText(Double.toString(avgGrade));
        }
    }


    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        SemesterAvg myGrades = new SemesterAvg();
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
