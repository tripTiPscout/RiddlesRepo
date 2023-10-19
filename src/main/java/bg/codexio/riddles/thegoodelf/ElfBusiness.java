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
        int[] frequency1 = getLettersFrequency(word1);
        int[] frequency2 = getLettersFrequency(word2);

        return getLettersToRemove(frequency1, frequency2);
    }

    private static int[] getLettersFrequency(String word) {
        int[] lettersFrequency = new int[26];

        for (char c : word.toLowerCase(Locale.ROOT).toCharArray()) {
            lettersFrequency[c - 'a']++;
        }

        return lettersFrequency;
    }

    private static int getLettersToRemove(int[] frequency1, int[] frequency2) {
        int lettersToRemove = 0;

        for (int i = 0; i < 26; i++) {
            lettersToRemove += Math.abs(frequency1[i] - frequency2[i]);
        }

        return lettersToRemove;
    }

}
