package FileProcessor;

import DTOs.PortProtocol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileProcessor implements Processor {

    private static final String SPACE_DELIMITER = " ";
    public HashMap<String, Integer> matchesPerTagMap = new HashMap<>();
    public HashMap<PortProtocol, Integer> matchesPerPortAndProtocolMap = new HashMap<>();

    public void processInputFile(HashMap<PortProtocol, String> lookupMap, HashMap<String, String> protocolNumbersMap, String inputFile) throws FileNotFoundException {
        try (Scanner myReader = new Scanner(new File(inputFile))) {
            while (myReader.hasNextLine()) {
                String[] row = myReader.nextLine().split(SPACE_DELIMITER);
                PortProtocol portProtocol = new PortProtocol(row[6], protocolNumbersMap.get(row[7]));

                String tag = lookupMap.getOrDefault(portProtocol, "Untagged");
                matchesPerTagMap.put(tag, matchesPerTagMap.getOrDefault(tag, 0) + 1);
                matchesPerPortAndProtocolMap.put(portProtocol, matchesPerPortAndProtocolMap.getOrDefault(portProtocol, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
