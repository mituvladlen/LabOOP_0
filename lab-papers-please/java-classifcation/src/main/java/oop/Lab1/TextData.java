package oop.Lab1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
        processText();
    }

    private void processText() {
        numberOfVowels = countVowels();
        numberOfConsonants = countConsonants();
        numberOfLetters = numberOfVowels + numberOfConsonants;
        numberOfSentences = countSentences();
        longestWord = findLongestWord();
    }

    private int countVowels() {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    private int countConsonants() {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) {
                count++;
            }
        }
        return count;
    }

    private int countSentences() {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == '!' || c == '?') {
                count++;
            }
        }
        return count;
    }

    private String findLongestWord() {
        String longest = "";
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public String getFileName() {
        return fileName;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }
}
