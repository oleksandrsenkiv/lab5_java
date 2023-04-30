package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TextProcessorTest {
    private TextProcessor textProcessor = new TextProcessor();

    private String correctWords = "Are you Johns ";
    private String expectedEmptyString = "";
    private final int wordLength = 3;
    private final String letter = "J";

    @Test
    void testWithCorrectWords() {
        String text = "Today Johns birthday. Are you happy?";
        String result = textProcessor.textProcessing(text,wordLength,letter);
        Assertions.assertEquals(correctWords,result);

    }
    @Test
    public void testWithoutCorrectWords(){
        String text = "Hello world";
        String result = textProcessor.textProcessing(text,wordLength,letter);
        Assertions.assertEquals(expectedEmptyString,result);
    }
    @Test
    public void testEmptyString(){
        String emptyString = "";
        String result = textProcessor.textProcessing(emptyString,wordLength,letter);
        Assertions.assertEquals(expectedEmptyString,result);

    }
}