//public class Main {
//
//    public static void main(String[] args) {
//        // Test Utils.java
//
//        String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
//        System.out.println(data);
//    }
//}

import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.rmi.server.ExportException;

public class Main {

    public static void main(String[] args) {
        // Test Utils.java

        // String data = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        // String data = Utils.readFileAsStringAndCleanup("data/a.csv");

        String data = Utils.readFileAsStringAndCleanup("data/2016_Presidential_Results.csv");

        try{

            Writer writer= new PrintWriter(new File("data/output.csv"));
            writer.write(data.toString());
            System.out.println(data);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

