package FileReader;

import DTOs.PortProtocol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader implements Reader {

    private static final String COMMA_DELIMITER = ",";
    public HashMap<PortProtocol, String> lookupMap;
    public HashMap<String, String> protocolNumbersMap;

    @Override
    public void lookupTableFileReader(String lookupTableFile, boolean skipFirstLine) throws FileNotFoundException {
        lookupMap = new HashMap<>();
        Scanner scanner = new Scanner(new File(lookupTableFile));
        while (scanner.hasNextLine()) {
            if (skipFirstLine) {
                skipFirstLine = false;
                scanner.nextLine();
                continue;
            }

            String[] row = scanner.nextLine().split(COMMA_DELIMITER);
            lookupMap.put(new PortProtocol(row[0], row[1]), row[2]);
        }
    }

    @Override
    public void protocolsFileReader(String protocolsFile, boolean skipFirstLine) throws FileNotFoundException {
        protocolNumbersMap = new HashMap<>();
        Scanner scanner = new Scanner(new File(protocolsFile));
        while (scanner.hasNextLine()) {
            if (skipFirstLine) {
                skipFirstLine = false;
                scanner.nextLine();
                continue;
            }

            String[] row = scanner.nextLine().split(COMMA_DELIMITER);
            protocolNumbersMap.put(row[0].toLowerCase(), row[1].toLowerCase());
            if (row[0].equals("146-252")) {
                for (int i = 146; i <= 252; i++) {
                    protocolNumbersMap.put(String.valueOf(i), row[1]);
                }
            }
        }
    }
}
