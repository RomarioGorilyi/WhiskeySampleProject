package party;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Roman Horilyi on 28.10.2016.
 */
public class CaskTest {
    @Test
    public void shouldCreateImmutableInstance() {
        final Cask cask = new Cask(Cask.Type.BOURBON, 500);

        assertThat(cask.getType(), equalTo(Cask.Type.BOURBON));
        assertThat(cask.getLitres(), equalTo(500));
    }

}