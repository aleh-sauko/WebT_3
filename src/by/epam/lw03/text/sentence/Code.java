package by.epam.lw03.text.sentence;

/**
 * Created by aleh on 30.03.14.
 */
public class Code extends PartOfSentence {

    private String code;

    public Code(int position, String code) {
        super.setPosition(position);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String word) {
        this.code = word;
    }

    @Override
    public String toString() {
        return code;
    }
}
