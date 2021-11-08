package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        boolean isRemoved = false;
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)) {
                roster.remove(i);
                i--;
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Member")) {
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Trial")) {
                player.setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> list = new ArrayList<>();
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getClazz().equals(clazz)) {
                Player player = roster.remove(i);
                i--;
                list.add(player);
            }
        }
        return list.stream().toArray(value -> new Player[value]);
    }

    public int count() {
        return roster.size();
    }

    //    Players in the guild: {guildName}:
//{Player1}
//{Player2}
//(…)
    public String report() {
        StringBuilder stringBuilder = new StringBuilder(String.format("Players in the guild: %s:\n", name));
        for (Player player : roster) {
            stringBuilder.append(player.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
