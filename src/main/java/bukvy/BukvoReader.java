package bukvy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Manjago (kirill@temnenkov.com)
 */
public class BukvoReader {
    private final String prefix;

    public BukvoReader(String prefix) {
        this.prefix = prefix;
    }

    public List<String> doRead(String path) {
        List<String> result = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                tryAdd(sCurrentLine, result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void tryAdd(String rawLine, List<String> data) {
        if (rawLine == null) {
            return;
        }

        String line = rawLine.trim();

        if (line.length() < prefix.length()) {
            return;
        }

        if (!line.startsWith(prefix)) {
            return;
        }

        String[] e = line.split(" ");
        if (e.length == 0) {
            return;
        }

        String token = e[0];
        String upperToken = token.toUpperCase(Locale.getDefault());
        if (!token.equals(upperToken)) {
            return;
        }

        data.add(token);


    }
}
