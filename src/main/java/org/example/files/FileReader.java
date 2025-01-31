package org.example.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    public String readText(String filePath) throws IOException {
    Path path = Path.of(filePath);
        return new String(Files.readAllBytes(path));
    }

}
