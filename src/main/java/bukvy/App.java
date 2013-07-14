package bukvy;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        BukvoReader r = new BukvoReader("Н");
        List<Word> result = r.doRead("D:\\Projects\\bukvy\\test2.txt");
        if (result == null) {
            System.out.println("null");
        } else {
            System.out.println("size " + result.size());
            for (Word s : result) {
                System.out.println(s);
            }

            List<Word> sorted = new ArrayList<>();
            for (Word s : result) {
                sorted.add(s);
            }
            Collections.sort(sorted);

            for (int i = 0; i < result.size(); ++i) {
                if (!result.get(i).equals(sorted.get(i))) {
                    System.out.println(MessageFormat.format("mismatch {0}!={1} line {2}",
                            result.get(i), sorted.get(i), i));
                    break;
                }
            }
            System.out.println("Done");
        }
    }
}
