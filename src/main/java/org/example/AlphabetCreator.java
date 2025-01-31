package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlphabetCreator {
    public static List<Character> getAlphabetAndSymbols() {
        Character[] alphabetAndSymbolsArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z', '.', ',', '«', '»', '"', '\'', ':',
                '!', '?', ' '
        };
        List<Character> alphabetAndSymbols = new ArrayList<>(Arrays.asList(alphabetAndSymbolsArray));
        return alphabetAndSymbols;

    }

}
