//partial credits to andy bao for idea and help
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVparser {
// parses csv into 2d array
    public static String[][] readCsv(InputStream inp) {
        ArrayList<ArrayList<String>> arr = new ArrayList<>();

        // length of row with most data
        int maxLength = 0;

        // open input
        try(Scanner scanner = new Scanner(inp)) {
            // Loop as long as more rows
            while(scanner.hasNextLine()) {
                // row content
                ArrayList<String> splitLine = new ArrayList<>();

                // turn into string
                String line = scanner.nextLine();

                // holds current cell content
                StringBuilder cell = new StringBuilder();

                // state specifying whether or not the parser's position is currently in quotes
                boolean inQuotes = false;

                //CREDITS TO ANDY BAO
                // Go through every character in row
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i); // Get current character at position
                    if (c == '"') { // Is current character quote
                        // If we are in quotes, declare we are out of quotes
                        // If we are not in quotes, declare that we are in quotes
                        inQuotes = !inQuotes;
                    } else if (!inQuotes && c == ',') { // If we are not in quotes and current character is comma
                        // Add current cell content to cell list
                        splitLine.add(cell.toString());
                        // Clear cell content for next cell
                        cell.setLength(0);
                    } else {
                        // Add current character to cell content
                        cell.append(c);
                    }
                }

                //END CREDITS
                // still has cell, if not last cell
                if (cell.length() > 0) {
                    // Add cell content to cell list
                    splitLine.add(cell.toString());
                }

                // Random memory optimization we don't actually need but I put it in because I was bored
                //splitLine.trimToSize();

                // add current row to list
                arr.add(splitLine);

                // update max length if needed
                if (maxLength < splitLine.size())
                    maxLength = splitLine.size();
            }
        }

        String[][] result = new String[arr.size()][maxLength];

        // copy data from list to data array
        for(int y = 0; y < result.length; y++) {
            ArrayList<String> a = arr.get(y);
            for (int x = 0; x < a.size(); x++)
                result[y][x] = a.get(x);
        }

        // return array
        return result;
    }
}

