package org.Nee.anagram;

public class AnagramCreator {
    private static final String SPACE_DELIMITER = " ";

    public String makeAnagram(String sentence) {
        validateSentence(sentence);
        String[] words = sentence.split(SPACE_DELIMITER);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            stringBuilder.append(reversedWord(word) + " ");
        }
        return String.valueOf(stringBuilder);
    }

    private void validateSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("sentence is null");
        }
        if (sentence.isEmpty()) {
            throw new IllegalArgumentException("sentence is empty");
        }
        if (sentence.matches("\\s*")) {
            throw new IllegalArgumentException("sentence contains only spaces or/and tabs");
        }
    }

    private boolean isLetter(char symbol) {
        return Character.isLetter(symbol);
    }

    private String reversedWord(String word) {
        char[] partsOfTheWord = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int firstArrayIndex = 0;
        int lastArrayIndex = partsOfTheWord.length - 1;
        while (!(firstArrayIndex == partsOfTheWord.length)) {
            char partOfWord = 0;
            char begining;
            char ending;
            try {
                if (isLetter(partsOfTheWord[firstArrayIndex]) && isLetter(partsOfTheWord[lastArrayIndex])) {
                    begining = partsOfTheWord[firstArrayIndex];
                    ending = partsOfTheWord[lastArrayIndex];
                    partOfWord = ending;
                    ending = begining;
                    begining = partOfWord;
                    firstArrayIndex++;
                    lastArrayIndex--;
                }
                else if (!isLetter(partsOfTheWord[firstArrayIndex])) {
                    partOfWord = partsOfTheWord[firstArrayIndex];
                    firstArrayIndex++;
                }
                else if (!isLetter(partsOfTheWord[lastArrayIndex])) {
                    lastArrayIndex--;
                    continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                partOfWord = partsOfTheWord[firstArrayIndex];
                break;
            }
            stringBuilder.append(partOfWord);
        }
        return String.valueOf(stringBuilder);
    }
}
