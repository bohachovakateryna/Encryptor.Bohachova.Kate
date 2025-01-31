package org.example.files;

import org.example.AlphabetCreator;
import org.example.CaesarsCipher;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class CLI {
    public static void beginProgram() {
        Scanner console = new Scanner(System.in);


        System.out.println("What do you want to do with the text?");
        System.out.println("[e] to encrypt | [d] to decrypt | [b] to brute-force");
        String begin = console.nextLine().trim().toLowerCase();

        int key = 0;
        if (begin.equals("e") || begin.equals("d")) {

            System.out.println("Enter key:");
            while (!console.hasNextInt()) {
                System.out.println("Invalid key. Please enter a numeric value:");
                console.next();
            }
            key = console.nextInt();
            console.nextLine();
        } else if (!begin.equals("b")) {
            System.out.println("Invalid option. Please choose [e], [d], or [b].");
            return;
        }


        System.out.println("Enter FilePath:");
        String filePath = console.nextLine().trim();

        try {
            FileReader fileReader = new FileReader();
            String text = fileReader.readText(filePath);
            List<Character> alphabet = AlphabetCreator.getAlphabetAndSymbols();
            String result = "";

            switch (begin) {
                case "e":
                    result = CaesarsCipher.encrypt(text, key, alphabet);
                    break;
                case "d":
                    result = CaesarsCipher.decrypt(text, key, alphabet);
                    break;
                case "b":
                    result = CaesarsCipher.bruteForce(text, alphabet);
                    break;
            }


            String operationType = switch (begin) {
                case "e" -> "ENCRYPT";
                case "d" -> "DECRYPT";
                case "b" -> "BRUTE_FORCE";
                default -> "RESULT";
            };
            String outputFilePath = FileService.generateOutputFilePath(filePath, operationType);


            FileWriter fileWriter = new FileWriter();
            fileWriter.writeText(outputFilePath, result);

            System.out.println("Operation completed. Result saved to: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }
}

