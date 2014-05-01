package by.epam.lw03.text.sentence;

/**
 * Created by aleh on 30.03.14.
 */
public class Punctuation extends PartOfSentence {

    private String punctuation;

    public Punctuation(int position, String punctuation) {
        super.setPosition(position);
        this.punctuation = punctuation;
    }

    public String getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String toString() {
        return punctuation;
    }
}
