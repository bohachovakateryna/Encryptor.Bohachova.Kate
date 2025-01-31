package org.example.files;

public class FileService {
    public static String generateOutputFilePath(String filePath, String command) {
        int dotIndex = filePath.lastIndexOf(".");
        String baseName = (dotIndex == -1) ? filePath : filePath.substring(0, dotIndex);
        String extension = (dotIndex == -1) ? "" : filePath.substring(dotIndex);
        String suffix = switch (command) {
            case "ENCRYPT" -> "[ENCRYPTED]";
            case "DECRYPT" -> "[DECRYPTED]";
            case "BRUTE_FORCE" -> "[BRUTE_FORCED]";
            default -> "[RESULT]";
        };
        return baseName + suffix + extension;
    }
}
