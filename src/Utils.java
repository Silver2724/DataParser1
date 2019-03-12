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
            if(data.contains("")) {
                removeSymbols(data, electionResults);
            }
            if(data.contains("%")){
                removeSymbols(data, electionResults);
            }
            ElectionResult result = new ElectionResult();
            electionResults.add(result);
        }
        return electionResults;
    }

    private static void removeSymbols(String data, ArrayList<ElectionResult> electionResults) {
        //removes quotes, perecnt signs, etc.
        electionResults.remove("%");
        electionResults.remove("");
    }
}
