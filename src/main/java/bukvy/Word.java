package bukvy;

/**
 * @author Manjago (kirill@temnenkov.com)
 */
public class Word implements Comparable<Word> {
    private final String key;
    private final String data;
    private final int sourceLine;

    public Word(String word, int sourceLine) {
        data = word;
        //todo переписать
        key = word.replace("-", "").replace(".", "").replace("’", "").replace("Ё", "Е");
        this.sourceLine = sourceLine;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Word word = (Word) o;
        return getKey().compareTo(word.getKey()) == 0;
    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Word{");
        sb.append("key='").append(key).append('\'');
        sb.append(", data='").append(data).append('\'');
        sb.append(", sourceLine=").append(sourceLine);
        sb.append('}');
        return sb.toString();
    }
}
