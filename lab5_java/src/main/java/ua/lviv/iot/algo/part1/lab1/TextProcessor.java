package ua.lviv.iot.algo.part1.lab1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessor {
    public String textProcessing(final String text, final int wordLength, final String letter) {

        Pattern pattern = Pattern.compile("\\b[A-Z][^?.!]*\\?");
        Matcher matcher = pattern.matcher(text);
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> uniqueWords = new HashSet<>();

        while (matcher.find()) {

            String sentence = matcher.group();
            Pattern wordPattern = Pattern.compile("\\b\\w{" + wordLength + "}\\b");
            Matcher wordMatcher = wordPattern.matcher(sentence);

            while (wordMatcher.find()) {

                String word = wordMatcher.group();

                if (!uniqueWords.contains(word)) {

                    uniqueWords.add(word);
                    stringBuilder.append(word).append(" ");

                }
            }
        }

        Pattern pattern2 = Pattern.compile("(?<=^|[.!?]\\s)\\w+\\s" + letter + "\\w*");
        Matcher matcher2 = pattern2.matcher(text);

        while (matcher2.find()) {

            String word = matcher2.group().split(" ")[1];
            stringBuilder.append(word).append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        TextProcessor textProcessor = new TextProcessor();
        String text = "Today Johns birthday. Are you happy?";

        String result = textProcessor.textProcessing(text, 3, "J");
        System.out.println(result);
        textProcessor.textProcessing(text, 3, "J");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the letter:");
        String writtenLetter = scanner.nextLine();

        System.out.println("Write word length:");
        int writtenLength = scanner.nextInt();

        System.out.println("Write the text: ");
        String writtenText = scanner.nextLine();

        scanner.close();

        String consoleResult = textProcessor.textProcessing(writtenText, writtenLength,writtenLetter);
        System.out.println(consoleResult);
    }
}