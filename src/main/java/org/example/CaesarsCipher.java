package org.example;

import java.util.List;

public class CaesarsCipher {
    public static String encrypt (String readText, int key, List<Character> alphabetAndSymbols){
        StringBuilder result = new StringBuilder();

        for ( char ch : readText.toCharArray() ){
            int index = alphabetAndSymbols.indexOf(ch);

            if( index!= -1){
                int upgradeIndex = (index + key) % alphabetAndSymbols.size();;
                result.append(alphabetAndSymbols.get(upgradeIndex));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String decrypt (String readText, int key, List<Character> alphabetAndSymbols) {
        StringBuilder result = new StringBuilder();
        for (char ch : readText.toCharArray()) {

            int index = alphabetAndSymbols.indexOf(ch);

            if (index != -1) {

                int upgradeIndex = (index - key + alphabetAndSymbols.size()) % alphabetAndSymbols.size();
                result.append(alphabetAndSymbols.get(upgradeIndex));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String  bruteForce(String encryptedText, List<Character> alphabetAndSymbols) {
        for ( int key = 1; key < alphabetAndSymbols.size(); key++){
            String decryptedText = decrypt(encryptedText, key, alphabetAndSymbols);

            int indexSymbol = decryptedText.indexOf(",");

            if (indexSymbol > 0) {
                String nextSymbol = decryptedText.substring(indexSymbol + 1);
                if (indexSymbol + 1 < decryptedText.length() && decryptedText.charAt(indexSymbol + 1) == ' ') {
                    System.out.println("Key found: " + key);
                    return decryptedText;
                }
            }
        }
        return "Не удалось расшифровать.";
    }



}
