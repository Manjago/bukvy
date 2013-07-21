package bukvy;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Manjago (kirill@temnenkov.com)
 */
public class WordTest {
    @Test
    public void testGetKey() throws Exception {

        Word w = new Word("-.r’Ё", 0);
        Assert.assertEquals("rЕ", w.getKey());

    }
}
