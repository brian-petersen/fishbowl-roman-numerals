package RomanNumerals;

import java.util.Map;
import java.util.TreeMap;

class Converter {

    private static TreeMap<Integer, String> symbols = new TreeMap<>();

    static {
        symbols.put(100, "C");
        symbols.put(90, "XC");
        symbols.put(50, "L");
        symbols.put(40, "XL");
        symbols.put(10, "X");
        symbols.put(9, "IX");
        symbols.put(5, "V");
        symbols.put(4, "IV");
        symbols.put(1, "I");
    }

    String convertNumber(int number) {
        if (number < 1 || number > 255) {
            throw new ConverterException("Number must be between 1-255. Was given " + number + ".");
        }

        StringBuilder value = new StringBuilder();

        while (number > 0) {
            Map.Entry<Integer, String> entry = symbols.floorEntry(number);

            value.append(entry.getValue());

            number -= entry.getKey();
        }

        return value.toString();
    }
}
