package org.example.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {
    public void writeText(String filePath , String text) throws IOException {
        Path path = Path.of(filePath);


        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }


        if (!Files.exists(path)) {
            Files.createFile(path);
        }


        Files.write(path, text.getBytes());
    }
}
