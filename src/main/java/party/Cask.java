package party;

import lombok.Value;

/**
 * Created by Roman Horilyi on 28.10.2016.
 */
@Value
public class Cask {
    private final Type type;

    private final int litres;

    public enum Type {FRESH, BOURBON, SHERRY}
}
