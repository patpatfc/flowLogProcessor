import FileReader.FileReader;
import FileWriter.FileWriter;
import FileProcessor.FileProcessor;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        if (args.length != 4 && args.length != 5) {
            System.out.println("Incorrect usage: ");
            return;
        }

        // read lookupTableFile
        FileReader fileReader = new FileReader();
        try {
            fileReader.lookupTableFileReader(args[0], true);
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found: " + args[0]);
            return;
        }

        // read protocolsFile
        try {
            fileReader.protocolsFileReader(args[1], true);
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found: " + args[1]);
            return;
        }

        // inputFile
        FileProcessor fileProcessor = new FileProcessor();
        try {
            fileProcessor.processInputFile(fileReader.lookupMap, fileReader.protocolNumbersMap, args[2]);
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found: " + args[2]);
            return;
        }

        // Write output to files
        FileWriter fileWriter = new FileWriter();
        if (args.length == 5) {
            try (java.io.FileWriter writer = new java.io.FileWriter(args[3])) {
                fileWriter.writeCountOfMatchesForEachPort(writer, fileProcessor.matchesPerPortAndProtocolMap);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (java.io.FileWriter writer = new java.io.FileWriter(args[4])) {
                fileWriter.writeCountOfMatchesForEachTag(writer, fileProcessor.matchesPerTagMap);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            // Write output to file
            try (java.io.FileWriter writer = new java.io.FileWriter(args[3])) {
                fileWriter.writeCountOfMatchesForEachPort(writer, fileProcessor.matchesPerPortAndProtocolMap);
                writer.append("\n");
                fileWriter.writeCountOfMatchesForEachTag(writer, fileProcessor.matchesPerTagMap);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}