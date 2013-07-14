package bukvy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manjago (kirill@temnenkov.com)
 */
public class BukvoReader {
    private final String prefix;

    public BukvoReader(String prefix) {
        this.prefix = prefix;
    }

    List<String> doRead(String path) {
        List<String> result = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                result.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
