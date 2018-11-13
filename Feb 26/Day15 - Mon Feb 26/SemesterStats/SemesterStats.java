/*
 * SemesterStats.java from Chapter 11
 * Computes the average, min, and max of the grades entered by the user.
 * Lawrenceville Press
 * June 10, 2005
 */
 
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;        

public class SemesterStats {
	JFrame frame;
	JPanel contentPane;
	JLabel prompt1, prompt2, prompt3, stat;
	JTextField grade1, grade2, grade3;
	JButton avgButton, minButton, maxButton;
	
    public SemesterStats(){
        /* Create and set up the frame */
        frame = new JFrame("Semester Stats");
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

		/* Create and add button that will display the average grade */
        avgButton = new JButton("Average");
    	avgButton.addActionListener(new AvgListener());
    	contentPane.add(avgButton);

		/* Create and add button that will display the min grade */
        minButton = new JButton("Min");
        minButton.setActionCommand("Min");
    	minButton.addActionListener(new MinMaxListener());
    	contentPane.add(minButton);

		/* Create and add button that will display the max grade */
        maxButton = new JButton("Max");
        maxButton.setActionCommand("Max");
    	maxButton.addActionListener(new MinMaxListener());
    	contentPane.add(maxButton);

		/* Create and add a label that will display stats */
	    stat = new JLabel(" ");
	    stat.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
	    contentPane.add(stat);

		/* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }
    
    
    class AvgListener implements ActionListener {
    	
		/**
		 * Handle Average button click event
		 * pre: none
		 * post: The grade average has been calculated and displayed.
		 */
    	public void actionPerformed(ActionEvent event) {
        	double avgGrade;
        	String g1 = grade1.getText();
        	String g2 = grade2.getText();
        	String g3 = grade3.getText();
        	
        	avgGrade = (Double.parseDouble(g1) + Double.parseDouble(g2) + 
	        			Double.parseDouble(g3))/3;
    	    stat.setText(Double.toString(avgGrade));
    	}
    }


    class MinMaxListener implements ActionListener {
    	
		/**
		 * Handles the Min and Max button click events
		 * pre: none
		 * post: The minimum or maximum grade has been determined and displayed.
		 */
    	public void actionPerformed(ActionEvent event) {
        	String eventName = event.getActionCommand();
        	double minGrade = 999;
        	double maxGrade = 0;
        	double[] grades = new double[3];
        	
        	grades[0] = Double.parseDouble(grade1.getText());
        	grades[1] = Double.parseDouble(grade2.getText());
        	grades[2] = Double.parseDouble(grade3.getText());
			
			if (eventName.equals("Min")) {
				for (int i = 0; i < 3; i++) {
					if (minGrade > grades[i]) {
						minGrade = grades[i];
					}
				}
				stat.setText(Double.toString(minGrade));
			} else if (eventName.equals("Max")) {
				for (int i = 0; i < 3; i++) {
					if (maxGrade < grades[i]) {
						maxGrade = grades[i];
					}
				}
				stat.setText(Double.toString(maxGrade));
    		}
    	}
    }


    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        SemesterStats myGrades = new SemesterStats();
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
