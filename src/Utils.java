import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static ArrayList<ElectionResult> parse2016ElectionResults(String data) {
        ArrayList<ElectionResult> electionResults = new ArrayList<>();
        data.split("\n");
        for (int i = 1; i < data.length(); i++) {
            data.split(",");
            cleanLine(data);
            ElectionResult result = new ElectionResult();
            electionResults.add(result);
        }
        return electionResults;
    }

    private static String cleanLine(String row) {
        int firstQuote = row.indexOf("\"");
        int secondQuote = row.indexOf("\"", firstQuote + 1);

        while(firstQuote != -1 && secondQuote != -1) {
            row = cleanSubstring(row, firstQuote, secondQuote);

            firstQuote = row.indexOf("\"");
            secondQuote = row.indexOf("\"", firstQuote + 1);
        }
        return row;
    }

    private static String cleanSubstring(String row, int firstQuote, int secondQuote) {
        String before = row.substring(0, firstQuote);
        String after = row.substring(secondQuote + 1);

        String toClean = row.substring(firstQuote + 1, secondQuote);

        return before + clean(toClean) + after;
    }

    private static String clean(String toClean) {
        toClean = toClean.replaceAll(",", "").trim();
        toClean = toClean.replaceAll("%", "");

        return toClean;
    }

    /*boolean isInteger(String str) {

int n = 0;

try {

n = Integer.parseInt(str);

} catch (NumberFormatException e) {

return false;

}

return true;

}

boolean containsLetters(String str) { … }

boolean containsAnyOf(String str, int start, int end, String chars)

String[] vals = line.split(“,”);

if (isValidToParse( vals )) {

// do it & add object

}

…

boolean isValidToParse( String[] vals ) {

if ( ! isInteger( vals[3] ) ) return false;

if ( vals[4].length() < 1) return false;

if ( containsAnyOf( vals[5], 3, 6, “,\”%”)) return false;

return true;
}*/
}
