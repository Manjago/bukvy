package bukvy;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        BukvoReader r = new BukvoReader("Н");
        List<String> result = r.doRead("D:\\Projects\\bukvy\\test.txt");
        if (result == null) {
            System.out.println("null");
        } else {
            for (String s : result) {
                System.out.println(s);
            }
        }
    }
}
