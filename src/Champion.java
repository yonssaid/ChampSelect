import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Champion {
    public String name, role, damageType;
    public Set<String> counters, synergyWith;
    public double winRate;

    public Champion(String name, String role, String damageType, double winRate,
                    String[] counters, String[] synergyWith) {
        this.name = name;
        this.role = role;
        this.damageType = damageType;
        this.winRate = winRate;
        this.counters = new HashSet<>(Arrays.asList(counters));
        this.synergyWith = new HashSet<>(Arrays.asList(synergyWith));
    }


    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getDamageType() {
        return damageType;
    }

    public double getWinRate() {
        return winRate;
    }

    public Set<String> getCounters() {
        return counters;
    }

    public Set<String> getSynergyWith() {
        return synergyWith;
    }
}
