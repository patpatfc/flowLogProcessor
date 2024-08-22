package FileProcessor;

import DTOs.PortProtocol;

import java.io.FileNotFoundException;
import java.util.HashMap;

interface Processor {
    void processInputFile(HashMap<PortProtocol, String> lookupMap, HashMap<String, String> protocolNumbersMap, String inputFile) throws FileNotFoundException;
}
