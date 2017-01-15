package party;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by Roman Horilyi on 28.10.2016.
 */
@RequiredArgsConstructor(staticName = "of")
@Accessors(fluent = true)
public class Bottle {

    @Getter
    @NonNull
    private final Whiskey whiskey;

    @Getter
    @Setter
    private int producedInYear;
}
