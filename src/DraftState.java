import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DraftState {
    List<Champion> team;
    Set<String> rolesFilled;
    double gCost; 
    double fCost;

    public DraftState(List<Champion> team, double gCost, double fCost) {
        this.team = team;
        this.rolesFilled = new HashSet<>();
        for (Champion c : team) rolesFilled.add(c.role);
        this.gCost = gCost;
        this.fCost = fCost;
    }
}
