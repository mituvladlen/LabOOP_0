package oop.Lab1;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class TextFileProcessor {
    public static void main(String[] args) {
        for (String filePath : args) {
            try {
                String text = Files.readString(Paths.get(filePath));
                TextData textData = new TextData(filePath, text);

                System.out.println("File: " + textData.getFileName());
                System.out.println("Number of Vowels: " + textData.getNumberOfVowels());
                System.out.println("Number of Consonants: " + textData.getNumberOfConsonants());
                System.out.println("Number of Letters: " + textData.getNumberOfLetters());
                System.out.println("Number of Sentences: " + textData.getNumberOfSentences());
                System.out.println("Longest Word: " + textData.getLongestWord());
                System.out.println("------------------------------");
            } catch (IOException e) {
                System.err.println("Failed to read file: " + filePath);
            }
        }
    }
}
