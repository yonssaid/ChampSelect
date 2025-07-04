import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Champion> pool = List.of(
                new Champion("Garen", "Top", "Physical", 51.0, new String[]{"Darius"}, new String[]{"Amumu"}),
                new Champion("Teemo", "Top", "Magic", 49.0, new String[]{"Nasus"}, new String[]{"Lux"}),
                new Champion("Darius", "Top", "Physical", 50.0, new String[]{"Garen"}, new String[]{"Nautilus"}),
                new Champion("Amumu", "Jungle", "Magic", 53.0, new String[]{"Lee Sin"}, new String[]{"Garen", "Lux"}),
                new Champion("Lee Sin", "Jungle", "Physical", 47.0, new String[]{"Amumu"}, new String[]{"Zed"}),
                new Champion("Warwick", "Jungle", "Physical", 50.0, new String[]{"Kindred"}, new String[]{"Teemo"}),
                new Champion("Lux", "Mid", "Magic", 52.0, new String[]{"Zed"}, new String[]{"Amumu"}),
                new Champion("Zed", "Mid", "Physical", 48.0, new String[]{"Lux"}, new String[]{"Lee Sin"}),
                new Champion("Kassadin", "Mid", "Magic", 54.0, new String[]{"Lux"}, new String[]{"Amumu"}),
                new Champion("Jinx", "ADC", "Physical", 55.0, new String[]{"Vayne"}, new String[]{"Nautilus", "Lux"}),
                new Champion("Vayne", "ADC", "Physical", 45.0, new String[]{"Jinx"}, new String[]{"Thresh"}),
                new Champion("Ashe", "ADC", "Physical", 50.0, new String[]{"Ezreal"}, new String[]{"Lux"}),
                new Champion("Nautilus", "Support", "Magic", 52.0, new String[]{"Thresh"}, new String[]{"Jinx", "Amumu"}),
                new Champion("Thresh", "Support", "Magic", 48.0, new String[]{"Nautilus"}, new String[]{"Vayne"}),
                new Champion("Soraka", "Support", "Magic", 50.0, new String[]{"Nautilus"}, new String[]{"Ashe", "Jinx"})
        );

        Scanner scanner = new Scanner(System.in);
        List<Champion> enemyPicks = new ArrayList<>();
        System.out.println("Enter enemy picks (type DONE when finished):");

        while (enemyPicks.size() < 5) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("DONE")) break;
            Champion match = pool.stream()
                    .filter(c -> c.name.equalsIgnoreCase(input))
                    .findFirst().orElse(null);
            if (match != null) {
                enemyPicks.add(match);
                System.out.println("✓ Added: " + match.name);
            } else {
                System.out.println("Champion not found. Try again.");
            }
        }
        ChampionRecommender recommender = new ChampionRecommender(pool, enemyPicks);
        List<Champion> team = recommender.recommendTeamAStar();

        System.out.println("\nRecommended Team:");
        for (Champion c : team) {
            System.out.printf(" - %s (%s, %s, %.1f%% win rate)\n", c.name, c.role, c.damageType, c.winRate);
        }
    }
}

