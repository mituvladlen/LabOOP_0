package oop.Lab1;

public class TextFileProcessor {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a file path as a program argument.");
            return;
        }

        String filePath = args[0];

        // Read file content
        FileReader fileReader = new FileReader();
        String textContent = fileReader.readFileIntoString(filePath);

        if (textContent != null) {
            TextData textData = new TextData(textContent);
            System.out.println("File: " + textData.getFilename());
            System.out.println("Text: " + textData.getText());
            System.out.println("Vowels: " + textData.getNumberOfVowels());
            System.out.println("Consonants: " + textData.getNumberOfConsonants());
            System.out.println("Letters: " + textData.getNumberOfLetters());
            System.out.println("Sentences: " + textData.getNumberOfSentences());
            System.out.println("Longest Word: " + textData.getLongestWord());
        }
    }
}
