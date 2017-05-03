import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MovieTest {

    private Movie m1;

    @Before
    public void setup() {
        m1 = new NewReleaseMovie("movie1");
    }

    @Test
    public void testSettingTitle() throws Exception {
        assertEquals("movie1", m1.getTitle());
    }

}
