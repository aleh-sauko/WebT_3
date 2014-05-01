package by.epam.lw03.parser;

import by.epam.lw03.text.PartOfText;
import by.epam.lw03.text.SentenceComparator;
import by.epam.lw03.text.sentence.*;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aleh on 30.03.14.
 */
public class TextParser {

    private TextParser() {}

    public static Collection<PartOfText> parseText(File f) throws IOException {
        return parseText(readFile(f.getAbsolutePath(), Charset.forName("UTF-8")));
    }

    public static Collection<PartOfText> parseText(String text) {

        Collection<PartOfText> partsOfText = new TreeSet<PartOfText>(new SentenceComparator());

        Pattern pattern = Pattern.compile("([^.!?]+[.!?])");
        Matcher matcher = pattern.matcher(text);
        int i = 0;
        while (matcher.find()) {
            String match = matcher.group();
            Sentence sentence = new Sentence(matcher.start(), parseSentence(match));
            partsOfText.add(sentence);
        }

        return partsOfText;
    }

    public static Collection<PartOfSentence> parseSentence(String sentence) {

        sentence = sentence.replaceAll("\r", "\n");

        Collection<PartOfSentence> parts = new TreeSet<PartOfSentence>();

        Pattern codePattern = Pattern.compile("(\\{[^}]+})");
        Matcher codeMatcher = codePattern.matcher(sentence);
        while (codeMatcher.find()) {
            if (codeMatcher.group(1) != null) {
                Code code = new Code(codeMatcher.start(1), codeMatcher.group(1));
                parts.add(code);
            }
        }

        Pattern wordPattern = Pattern.compile("(\\w+)|(\\W+)");
        Matcher wordMatcher = wordPattern.matcher(sentence);
        while (wordMatcher.find()) {
            if (wordMatcher.group(1) != null) {
                Word word = new Word(wordMatcher.start(1), wordMatcher.group(1));
                parts.add(word);
            }
            if (wordMatcher.group(2) != null) {
                Punctuation punctuation = new Punctuation(wordMatcher.start(2), wordMatcher.group(2));
                parts.add(punctuation);
            }
        }

        return parts;
    }


    private static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
}
