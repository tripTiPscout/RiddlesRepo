package bg.codexio.riddles.thegoodelf;

import java.util.Locale;
import java.util.Scanner;

public class ElfBusiness {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();

        if (!firstWord.matches("[a-zA-Z]+") || !secondWord.matches("[a-zA-Z]+")) {
            System.out.println("Some of the words contain unexpected symbols.");
            return;
        }

        int result = calculateLettersToRemove(firstWord, secondWord);
        System.out.printf("The Elf crosses out %d different letters from this two words: %s, %s.\n",
                result, firstWord, secondWord);
    }

    public static int calculateLettersToRemove(String word1, String word2) {
        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];

        for (char c : word1.toLowerCase(Locale.ROOT).toCharArray()) {
            frequency1[c - 'a']++;
        }

        for (char c : word2.toLowerCase(Locale.ROOT).toCharArray()) {
            frequency2[c - 'a']++;
        }

        int lettersToRemove = 0;
        for (int i = 0; i < 26; i++) {
            lettersToRemove += Math.abs(frequency1[i] - frequency2[i]);
        }

        return lettersToRemove;
    }
}
