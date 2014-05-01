package by.epam.lw03;

import by.epam.lw03.parser.TextParser;
import by.epam.lw03.task.Second;
import by.epam.lw03.task.Task;
import by.epam.lw03.task.Third;
import by.epam.lw03.text.Text;

import java.io.File;
import java.io.IOException;

/**
 * Created by aleh on 02.04.14.
 */
public class Launcher {

    public static void main(String[] args) {

        File f = new File("test.txt");

        try {
            Text text = new Text(TextParser.parseText(f));
            text.printText();

            Task second = new Second();
            second.execute(text);

            Task third = new Third();
            third.execute(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
