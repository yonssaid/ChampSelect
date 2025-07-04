import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChampionTest {

    @Test
    public void testChampionFields() {
        Champion champ = new Champion(
                "Garen", "Top", "Physical", 51.0,
                new String[]{"Darius"}, new String[]{"Lux"}
        );

        assertEquals("Garen", champ.getName());
        assertEquals("Top", champ.getRole());
        assertEquals("Physical", champ.getDamageType());
        assertEquals(51.0, champ.getWinRate());
        assertTrue(champ.getCounters().contains("Darius"));
        assertTrue(champ.getSynergyWith().contains("Lux"));
    }
}
