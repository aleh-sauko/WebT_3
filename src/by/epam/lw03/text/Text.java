package by.epam.lw03.text;


import java.util.*;

/**
 * Created by aleh on 30.03.14.
 */
public class Text {

    private Collection<PartOfText> partsOfText = new TreeSet<PartOfText>(new SentenceComparator());

    public Text(Collection<PartOfText> partsOfText) {
        this.partsOfText = partsOfText;
    }

    public void printText() {
        for (PartOfText part : partsOfText) {
            System.out.print(part);
        }
        System.out.println();
    }

    public Collection<PartOfText> getPartsOfText() {
        return partsOfText;
    }

    public void setPartsOfText(Collection<PartOfText> partsOfText) {
        this.partsOfText = partsOfText;
    }


}
