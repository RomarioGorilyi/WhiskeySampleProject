package party;

import lombok.val;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static party.PopularWhiskeys.*;
import static party.Whiskey.Material.*;

/**
 * Created by Roman Horilyi on 27.10.2016.
 */
public class WhiskeyTest {
    @Test
    public void shouldExposeWhiskeyStateViaGetters() {
        final Whiskey whiskey = JACK_DANIELS;

        assertThat(whiskey.getBrand(), equalTo("Jack Daniel's"));
        assertThat(whiskey.getLabel(), equalTo("Old No. 7"));
        assertThat(whiskey.getAbv(), equalTo(40));
        assertThat(whiskey.getMaterials().keySet(), hasItems(CORN, RYE, BARLEY));
        assertThat(whiskey.isBourbon(), equalTo(true));
        assertThat(whiskey.isSingleMaltBarley(), equalTo(false));
    }

    @Test
    public void shouldHaveWellBehavingEqualsAndHashCode() {
        val whiskeys = new HashSet<>(Arrays.asList(
                JACK_DANIELS,
                JOHNNIE_WALKER
        ));

        assertThat(whiskeys.contains(newJackDaniels()), is(true));
        assertThat(whiskeys.contains(BALVENIE), is(false));
    }

    @Test
    public void shouldNotEqualIfAtLeastOneFieldIsDifferent() {
        val notExactCopyOfJack = new Whiskey();
        notExactCopyOfJack.setBrand("Jack Daniel's");
        notExactCopyOfJack.setLabel("Old No. 8");

        assertThat(notExactCopyOfJack.equals(JACK_DANIELS), is(false));
    }

    @Test
    public void shouldPrintItself() {
        final String result = JACK_DANIELS.toString();

        System.out.println(result);

        assertThat(result, containsString("Jack Daniel's"));
        assertThat(result, containsString("Old No. 7"));
        assertThat(result, containsString("40"));
    }

    @Test
    public void shouldBeBourbonIfCornIsPredominant() {
        assertThat(JACK_DANIELS.isBourbon(), is(true));
        assertThat(JOHNNIE_WALKER.isBourbon(), is(false));
        assertThat(BALVENIE.isBourbon(), is(false));
    }

    @Test
    public void shouldBeSingleMaltBarleyIfBarleyIsTheOnlyRawMaterial() {
        assertThat(JACK_DANIELS.isSingleMaltBarley(), is(false));
        assertThat(JOHNNIE_WALKER.isSingleMaltBarley(), is(false));
        assertThat(BALVENIE.isSingleMaltBarley(), is(true));
    }
}
