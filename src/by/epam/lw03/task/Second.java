package by.epam.lw03.task;

import by.epam.lw03.text.PartOfText;
import by.epam.lw03.text.Text;
import by.epam.lw03.text.sentence.PartOfSentence;
import by.epam.lw03.text.sentence.Sentence;
import by.epam.lw03.text.sentence.Word;

import java.util.*;

/**
 * Created by aleh on 02.05.14.
 */
public class Second implements Task {

    @Override
    public void execute(Text text) {
        List<PartOfText> parts = new ArrayList<PartOfText>(text.getPartsOfText());
        Collections.sort(parts, new Comparator<PartOfText>() {
            @Override
            public int compare(PartOfText o1, PartOfText o2) {
                Collection<PartOfSentence> partOfFirstSentence = ((Sentence)o1).getPartsOfSentence();
                Collection<PartOfSentence> partOfSecondSentence = ((Sentence)o2).getPartsOfSentence();

                int wordInFirstSentence = 0;
                for (PartOfSentence part : partOfFirstSentence) {
                    if (part instanceof Word) {
                        wordInFirstSentence++;
                    }
                }

                int wordInSecondSentence = 0;
                for (PartOfSentence part : partOfSecondSentence) {
                    if (part instanceof Word) {
                        wordInSecondSentence++;
                    }
                }

                return wordInFirstSentence - wordInSecondSentence;
            }
        });


        System.out.println();
        System.out.println("####################### SECOND TASK EXECUTE ##############################");
        int i = 0;
        for (PartOfText part : parts) {
            System.out.println(++i + " : " + part);
        }
        System.out.println("#######################   SECOND TASK END   ##############################");
    }
}
