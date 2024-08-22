package FileWriter;

import DTOs.PortProtocol;

import java.io.IOException;
import java.util.HashMap;

public class FileWriter implements Writer {
    @Override
    public void writeCountOfMatchesForEachTag(java.io.FileWriter csvWriter, HashMap<String, Integer> matchesPerTagMap) {
        try {
            // Write header row
            csvWriter.append("Tag,Count\n");
            for (String key : matchesPerTagMap.keySet()) {
                csvWriter.append(key).append(",");
                csvWriter.append(matchesPerTagMap.get(key).toString()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeCountOfMatchesForEachPort(java.io.FileWriter csvWriter, HashMap<PortProtocol, Integer> matchesPerPortAndProtocolMap) {
        try {
            // Write header row
            csvWriter.append("Port,Protocol,Count\n");
            for (PortProtocol key : matchesPerPortAndProtocolMap.keySet()) {
                csvWriter.append(key.toString()).append(",");
                csvWriter.append(matchesPerPortAndProtocolMap.get(key).toString()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
