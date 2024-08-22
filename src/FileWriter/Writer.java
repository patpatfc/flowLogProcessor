package FileWriter;

import DTOs.PortProtocol;

import java.io.FileWriter;
import java.util.HashMap;

interface Writer {
    void writeCountOfMatchesForEachTag(FileWriter csvWriter, HashMap<String, Integer> matchesPerTagMap);
    void writeCountOfMatchesForEachPort(FileWriter csvWriter, HashMap<PortProtocol, Integer> matchesPerPortAndProtocolMap);
}
