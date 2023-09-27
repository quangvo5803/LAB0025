import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Controller.Program;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        try {
            int countLine = Program.countLine();
            int count = 1;
            br = new BufferedReader(new FileReader(new File("src/Model/input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/Model/output.txt", true)));
            String line;
            while ((line = br.readLine()) != null) {
                if (Program.isLineEmpty(line)) {
                    continue;
                }
                line = Program.formatOneSpace(line);
                line = Program.formatSpecialCharacters(line);
                line = Program.afterDotUpperCase(line);
                line = Program.noSpaceQuotes(line);
                line = Program.firstUpercase(line);
                line = Program.lastAddDot(line);
                pw.print(line);
                if (count < countLine) {
                    pw.print(System.getProperty("line.separator"));
                }
                count++;
            }
            br.close();
            pw.close();
            System.out.println("Normalize successful.");
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }
