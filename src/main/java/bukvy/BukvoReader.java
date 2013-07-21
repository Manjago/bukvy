package bukvy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
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

    public List<Word> doRead(String path) {
        List<Word> result = new ArrayList<Word>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), Charset.forName("UTF-8")))) {

            String sCurrentLine;
            int lineNum = 0;

            while ((sCurrentLine = br.readLine()) != null) {
                tryAdd(sCurrentLine, result, ++lineNum);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void tryAdd(String rawLine, List<Word> data, int linenum) {
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

        Word w = getWord(linenum, line);
        if (w == null) {
            return;
        }

        data.add(w);

    }

    private Word getWord(int linenum, String line) {
        String[] e = line.split(" ");
        if (e.length == 0) {
            return null;
        }

        String token = e[0];
        String upperToken = token.toUpperCase(Locale.getDefault());
        if (!token.equals(upperToken)) {
            return null;
        }

        Word w = new Word(token, linenum);
        if (w.getKey().equals(prefix)) {
            return null;
        }
        return w;
    }
}
