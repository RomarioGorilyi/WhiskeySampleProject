package party;

import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;
import static party.PopularWhiskeys.BALVENIE;
import static party.PopularWhiskeys.JACK_DANIELS;

/**
 * Created by Roman Horilyi on 28.10.2016.
 */
public class BarTest {
    @Test
    public void shouldBuildBar() {
        final Bar bar = Bar.builder()
                .openTime(LocalTime.of(18, 0))
                .closeTime(LocalTime.of(23, 0))
                .bartender("Mikalai")
                .bartender("Anna")
                .whiskey("jack", Bottle.of(JACK_DANIELS))
                .whiskey("bal", Bottle.of(BALVENIE))
                .build();

        assertThat(bar.getOpenTime(), equalTo(LocalTime.of(18, 0)));
        assertThat(bar.getCloseTime(), equalTo(LocalTime.of(23, 0)));
        assertThat(bar.getBartenders(), hasItems("Mikalai", "Anna"));
        assertThat(bar.getWhiskeys().get("jack").whiskey(), sameInstance(JACK_DANIELS));
        assertThat(bar.getWhiskeys().get("bal").whiskey(), sameInstance(BALVENIE));

        bar.recommendations();
    }

}