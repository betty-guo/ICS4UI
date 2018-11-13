/*
 Unit 3-4 Assignment 1 Question 1
 Betty Guo
 Creation Date: 05/21/18
 Problem: Write a program that reads a file and outputs in GUI for user

 REFERENCE:
 https://developer.apple.com/

 CREDITS:
 Major guidance from Andy Bao for parsing and telling me about GUI plugin!
 Partial credits for CSVparser (idea and guidance)
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

public class Main {

    //---------DECLARE VARIABLES-------------
    // Rows to skip at beginning of CSV
    private static int skipROWS = 32;
    // Initial item prompting user to select city
    private static String SELECTION_PROMPT = "Select a city";

    public static void main(String[] args) {
        // initialize GUI
        final GUI gui = new GUI();

        // create jframe and set characteristics
        final JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(700, 0));
        frame.setResizable(false);
        frame.add(gui.main); //add gui to frame
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // parse file
        final String[][] data = CSVparser.readCsv(Main.class.getResourceAsStream("eng-climate-summaries-All-4,2018.csv"));

        // add first blank item
        gui.citySelect.addItem(SELECTION_PROMPT);

        // add listener for combo box
        gui.citySelect.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                // smth in combo box is selected
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    DefaultTableModel model;
                    if(e.getItem().equals(SELECTION_PROMPT)) {
                        model = new DefaultTableModel(); //clear table if blank item is selected
                    } else {
                        String[] row = null;

                        // find row with selected name
                        for (int i = skipROWS; i < data.length; i++) {
                            row = data[i];
                            // stop if matching row found
                            if (row[0].equals(e.getItem().toString()))
                                break;
                        }

                        // add labels
                        List<Object[]> data = new ArrayList<>(Arrays.asList(new Object[][]{
                                {"Name", row[0]},
                                {"Latitude (North + , degrees)", row[1]},
                                {"Longitude (West - , degrees)", row[2]},
                                {"Province", row[3]},
                                {"Mean Temperature (°C)", row[4]},
                                {"Days Without Valid Mean Temperature", row[5]},
                                {"Mean Temperature Difference from Normal (1981-2010) (°C)", row[6]},
                                {"Highest Monthly Maximum Temperature (°C)", row[7]},
                                {"Days Without Valid Maximum Temperature", row[8]},
                                {"Lowest Monthly Minimum Temperature (°C)", row[9]},
                                {"Days Without Valid Minimum Temperature", row[10]},
                                {"Snowfall (cm)", row[11]},
                                {"Days Wwithout Valid Snowfall", row[12]},
                                {"Percent of Normal (1981-2010) Snowfall", row[13]},
                                {"Total Precipitation (mm)", row[14]},
                                {"Days Without Valid Precipitation", row[15]},
                                {"Percent of Normal (1981-2010) Precipitation", row[16]},
                                {"Snow on the Ground at the End of the Month (cm)", row[17]},
                                {"Number of Days with Precipitation 1.0 mm or More", row[18]},
                                {"Bright Sunshine (hours)", row[19]},
                                {"Days Without Valid Bright Sunshine", row[20]},
                                {"Percent of Normal (1981-2010) Bright Sunshine", row[21]},
                                {"Degree Days Below 18 °C", row[22]},
                                {"Degree Days Above 18 °C", row[23]},
                                {"Climate Identifier", row[24]}
                        }));

                        // go through rows with iterator and trim empty data
                        Iterator<Object[]> iterator = data.iterator();
                        while (iterator.hasNext()) {
                            Object[] item = iterator.next();
                            String value = ((String) item[1]).trim();

                            if (value.isEmpty() || value.equalsIgnoreCase("NA")) iterator.remove(); // Remove entry from data

                            // Update row data
                            item[1] = value;
                        }

                        // Create new model for table (can't edit)
                        model = new NoEdit(new Object[]{"Attribute", "Value"},
                                0); // Zero starting rows

                        // add each data entry to table
                        for (Object[] item : data)
                            model.addRow(item);
                    }

                    gui.infoTable.setModel(model);
                    //update window
                    frame.pack();
                }
            }
        });

        for(int y = skipROWS; y < data.length; y++) {
            gui.citySelect.addItem(data[y][0]); //add cities to combo box
        }

        // update window
        frame.pack();
    }
}

//make table noneditable
class NoEdit extends DefaultTableModel {

    NoEdit(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    //make fields noneditable
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

