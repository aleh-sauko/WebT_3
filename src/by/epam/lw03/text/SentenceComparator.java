package by.epam.lw03.text;

import java.util.Comparator;

/**
 * Created by aleh on 02.05.14.
 */
public class SentenceComparator implements Comparator<PartOfText> {

    @Override
    public int compare(PartOfText o1, PartOfText o2) {
        return o1.getPosition() - o2.getPosition();
    }
}
