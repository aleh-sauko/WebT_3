package by.epam.lw03.task;

import by.epam.lw03.text.PartOfText;
import by.epam.lw03.text.Text;
import by.epam.lw03.text.sentence.PartOfSentence;
import by.epam.lw03.text.sentence.Sentence;
import by.epam.lw03.text.sentence.Word;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by aleh on 02.05.14.
 */
public class Third implements Task {
    @Override
    public void execute(Text text) {
        List<Sentence> sentences = extractSentences(text);

        System.out.println();
        System.out.println("####################### THIRD TASK EXECUTE ##############################");
        Iterator<Sentence> iterator = sentences.iterator();
        List<Word> potencialWords = extractWord(iterator.next());
        while (iterator.hasNext()) {
            List<Word> deletedWord = extractWord(iterator.next());
            potencialWords.removeAll(deletedWord);
        }
        for (Word word : potencialWords) {
            System.out.println(word);
        }
        System.out.println("#######################   THIRD TASK END   ##############################");
    }

    private List<Sentence> extractSentences(Text text) {
        List<PartOfText> partOfTexts = new ArrayList<PartOfText>(text.getPartsOfText());
        List<Sentence> sentences = new ArrayList<Sentence>();
        for (PartOfText part : partOfTexts) {
            if (part instanceof Sentence) {
                sentences.add((Sentence)part);
            }
        }
        return sentences;
    }

    private List<Word> extractWord(Sentence sentence) {
        List<PartOfSentence> partOfSentences = new ArrayList<PartOfSentence>(sentence.getPartsOfSentence());
        List<Word> words = new ArrayList<Word>();
        for (PartOfSentence part : partOfSentences) {
            if (part instanceof Word) {
                words.add((Word)part);
            }
        }
        return words;
    }
}
