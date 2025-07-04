import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ChampionRecommender {
    List<Champion> championPool;
    List<Champion> enemyTeam;

    public ChampionRecommender(List<Champion> pool, List<Champion> enemyTeam) {
        this.championPool = pool;
        this.enemyTeam = enemyTeam;
    }

    public List<Champion> recommendTeamAStar() {
        PriorityQueue<DraftState> frontier = new PriorityQueue<>(Comparator.comparingDouble(d -> d.fCost));
        frontier.add(new DraftState(new ArrayList<>(), 0, 0));

        while (!frontier.isEmpty()) {
            DraftState current = frontier.poll();
            if (current.team.size() == 5) return current.team;

            for (Champion c : championPool) {
                if (current.rolesFilled.contains(c.role)) continue;
                if (current.team.contains(c)) continue;

                List<Champion> newTeam = new ArrayList<>(current.team);
                newTeam.add(c);
                double g = current.gCost + synergyPenalty(newTeam) + counterPenalty(c) + pickSafetyPenalty(c, newTeam.size());
                double h = heuristic(newTeam);
                frontier.add(new DraftState(newTeam, g, g + h));
            }
        }

        return null;
    }

    private double synergyPenalty(List<Champion> team) {
        long magic = team.stream().filter(c -> c.damageType.equals("Magic")).count();
        long phys = team.stream().filter(c -> c.damageType.equals("Physical")).count();
        return Math.abs(magic - phys);
    }

    private double counterPenalty(Champion c) {
        for (Champion enemy : enemyTeam) {
            if (c.counters.contains(enemy.name)) return -1;
            if (enemy.counters.contains(c.name)) return 2;
        }
        return 0.5;
    }

    private double pickSafetyPenalty(Champion c, int pickOrder) {
        if (pickOrder <= 2) return c.counters.isEmpty() ? 0 : 2;
        if (pickOrder >= 4) return c.counters.isEmpty() ? 2 : 0;
        return 1;
    }

    private double heuristic(List<Champion> team) {
        return (5 - team.size()) * 1.5;
    }
}