package RomanNumerals;

import java.io.IOException;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Program expects one argument: the path to the input file.");
            System.exit(1);
        }

        String inputFilePath = args[0];
        Parser parser = new Parser(Paths.get(inputFilePath));

        try {
            parser.parse();
        } catch (ParserException e) {
            System.err.println("Error occurred while parsing the input file:");
            e.printStackTrace(System.err);

            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace(System.err);

            System.exit(1);
        }

        int[] cases = parser.getCases();
        Converter converter = new Converter();

        for (int i = 0; i < cases.length; i++) {
            System.out.println("Case #" + (i + 1) + ": " + cases[i] + "=" + converter.convertNumber(cases[i]));
        }
    }
}
