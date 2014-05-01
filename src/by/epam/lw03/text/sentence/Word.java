package by.epam.lw03.text.sentence;

/**
 * Created by aleh on 30.03.14.
 */
public class Word extends PartOfSentence {

    private String word;

    public Word(int position, String word) {
        super.setPosition(position);
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (word == null ? 0 : word.hashCode())*43;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        Word o = (Word) obj;
        return (word == null ? o.word == null : word.equals(o.word));
    }
}
