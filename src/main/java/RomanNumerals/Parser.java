package RomanNumerals;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Parser {
    private int[] cases;

    private Path filePath;

    public Parser(Path filePath) {
        this.filePath = filePath;
    }

    public void parse() throws IOException, ParserException {
        Scanner scanner = new Scanner(filePath);

        // ensure the first token is the cases count
        if (!scanner.hasNextInt()) {
            throw new ParserException("Invalid input file. Was expecting the cases count.");
        }

        int casesCount = scanner.nextInt();

        cases = new int[casesCount];
        for (int i = 0; i < casesCount; i++) {
            if (!scanner.hasNextInt()) {
                throw new ParserException("Invalid input file. Not enough cases provided.");
            }

            cases[i] = scanner.nextInt();
        }

        // should have read all the file contents as this point
        if (scanner.hasNext()) {
            throw new ParserException("Invalid input file. Expected EOF.");
        }
    }

    public int[] getCases() {
        return cases;
    }
}
