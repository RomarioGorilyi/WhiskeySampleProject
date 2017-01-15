package party;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

import static party.Whiskey.Material.BARLEY;
import static party.Whiskey.Material.CORN;

/**
 * Created by Roman Horilyi on 27.10.2016.
 */
@Data
@EqualsAndHashCode(of = {"brand", "label"})
@ToString(exclude = "materials")
public class Whiskey {
    private String brand;
    private String label;
    private int abv = 40;

    public enum Material {BARLEY, CORN, RYE}

    @Getter(AccessLevel.PACKAGE)
    private final Map<Material, Integer> materials = new HashMap<>();

    private boolean blended;

    public boolean isBourbon() {
        return (abv >= 40) && (materials.getOrDefault(CORN, 0) >= 51);
    }

    public boolean isSingleMaltBarley() {
        return materials.getOrDefault(BARLEY, 0) == 100;
    }
}
