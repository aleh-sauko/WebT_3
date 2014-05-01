package by.epam.lw03.text.sentence;

/**
 * Created by aleh on 30.03.14.
 */
public abstract class PartOfSentence implements Comparable<PartOfSentence> {

    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int compareTo(PartOfSentence o) {
        return this.position - o.position;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
}
