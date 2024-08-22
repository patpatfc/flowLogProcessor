# flowLogProcessor
## About the project
In this project I implemented a flow Log Processor for Illumio Technical Assessment.

The Log Processor reads the Lookup Table to be used top map logs to tags (The Lookup Table that was provided in the 
assessment is located at lookupTableFile.csv). Then protocols file is read which I've downloaded from the following link
https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml (It can be found here: protocols.csv). I wanted
to make sure all protocols were in the hashmap and not only a select few thus I decided to follow this approach.
After both files are read, input file is read while mapping protocol numbers to protocol name and then tagging them. 
Count of matches for each tag and count of matches for each port/protocol combination file are updated as rows of input 
file are read. Finally, the results are written to a single or individual files depending on the arguments provided.

## Usage
```sh
java Main <Lookup Table> <Protocols> <Input File> <Output File 1 for Count of matches for each tag> <Output File 2 for Count of matches for each port/protocol combination file>
java Main <Lookup Table> <Protocols> <Input File> <Output File>
```

Example usage:
```sh
java Main Files/lookupTableFile.csv Files/protocols.csv Files/inputFile CountOfMatchesForEachPort.csv writeCountOfMatchesForEachTag.csv
```

## Improvements
For scalability purposes I would make the project multithreaded but I couldn't find the time as I had 72 hours to 
complete and I was busy with other work. I would say I spent around 6 hours of uninterrupted time working on 
the project. 