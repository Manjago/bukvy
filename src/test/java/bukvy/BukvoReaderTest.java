package bukvy;

import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Manjago (kirill@temnenkov.com)
 */
public class BukvoReaderTest {

    private String fullPath(String path) {
        return BukvoReaderTest.class.getResource(path).getPath();
    }

    @Test
    public void testDoRead() throws Exception {
        BukvoReader b = new BukvoReader("Н");
        List<String> result = b.doRead(fullPath("test.txt"));
        Assert.assertNotNull(result);
        Assert.assertEquals(5, result.size());
    }
}
