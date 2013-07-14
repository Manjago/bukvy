package bukvy;

/**
 * @author Manjago (kirill@temnenkov.com)
 */
public class Word implements Comparable<Word> {
    private final String key;
    private final String data;

    public Word(String word) {
        data = word;
        key = word.replace("-", "").replace(".", "");
    }

    public String getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    @Override
    public int compareTo(Word o) {
        return getKey().compareTo(o.getKey());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Word{");
        sb.append("key='").append(key).append('\'');
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
