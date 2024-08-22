package FileReader;

import java.io.FileNotFoundException;

interface Reader {
    void lookupTableFileReader(String lookupTableFile, boolean skipFirstLine) throws FileNotFoundException;
    void protocolsFileReader(String protocolsFile, boolean skipFirstLine) throws FileNotFoundException;
}
