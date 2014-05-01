package by.epam.lw03.text.sentence;

import by.epam.lw03.text.PartOfText;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Created by aleh on 30.03.14.
 */
public class Sentence extends PartOfText {

    private Collection<PartOfSentence> partsOfSentence;

    public Sentence(int position, Collection<PartOfSentence> partsOfSentence) {
        super.setPosition(position);
        this.partsOfSentence = partsOfSentence;
    }

    public Collection<PartOfSentence> getPartsOfSentence() {
        return partsOfSentence;
    }

    public void setPartsOfSentence(Collection<PartOfSentence> partsOfSentence) {
        this.partsOfSentence = partsOfSentence;
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (PartOfSentence part : partsOfSentence) {
            if (!(part instanceof Code)) {
                sentence.append(part);
            }
        }
        return sentence.toString();
    }
}
