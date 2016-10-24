package de.h_da.fbi.db2.tools;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by a.hofmann on 03.10.2016.
 */
public class CsvDataReader {
    private static final String SPLIT_CHARACTER = ";";

    private CsvDataReader() {}

    /**
     * Reads the embedded <code>Wissenstest_sample200.csv</code> file and returns its content in an accessible form
     * @return content of the related file as a list of split strings including the CSV-header at first position.
     * @throws URISyntaxException
     * @throws IOException
     */
    public static List<String[]> read() throws URISyntaxException, IOException {
        final URL resource = CsvDataReader.class.getResource("/Wissenstest_sample200.csv");
        if(resource == null) {
            throw new IllegalStateException("Unable to find the csv file.");
        }
        return readFile(new File(resource.toURI()));
    }

    private static List<String[]> readFile(File file) throws IOException {
        final List<String> lines = Files.readAllLines(file.toPath());
        return lines.stream()
                    .map((line) -> line.split(SPLIT_CHARACTER))
                    .collect(Collectors.toList());
    }
}
