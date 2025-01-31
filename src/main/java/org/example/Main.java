package org.example;


import org.example.files.CLI;
import org.example.files.FileReader;
import org.example.files.FileService;
import org.example.files.FileWriter;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            CLI.beginProgram();
            return;
        }

        if (args.length < 2 || args.length > 3) {
            System.out.println("Usage: java -jar myApp.jar [ENCRYPT|DECRYPT|BRUTE_FORCE] filePath [key]");
            return;
        }

        String command = args[0].toUpperCase();
        String filePath = args[1];
        int key = 0;

        if (!command.equals("BRUTE_FORCE") && args.length == 3) {
            try {
                key = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid key. Please provide a numeric value.");
                return;
            }
        } else if (!command.equals("BRUTE_FORCE")) {
            System.out.println("Key is required for ENCRYPT or DECRYPT commands.");
            return;
        }

        try {
            FileReader fileReader = new FileReader();
            String text = fileReader.readText(filePath);

            List<Character> alphabet = AlphabetCreator.getAlphabetAndSymbols();
            String result = "";

            switch (command) {
                case "ENCRYPT" -> result = CaesarsCipher.encrypt(text, key, alphabet);
                case "DECRYPT" -> result = CaesarsCipher.decrypt(text, key, alphabet);
                case "BRUTE_FORCE" -> result = CaesarsCipher.bruteForce(text, alphabet);
                default -> {
                    System.out.println("Invalid command. Use ENCRYPT, DECRYPT, or BRUTE_FORCE.");
                    return;
                }
            }

            String outputFilePath = FileService.generateOutputFilePath(filePath, command);
            FileWriter fileWriter = new FileWriter();
            fileWriter.writeText(outputFilePath, result);

            System.out.println("Operation completed. Result saved to: " + outputFilePath);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
