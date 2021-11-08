package guild;

public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    //    Player {name}: {clazz}
//    Rank: {rank}
//    Description: {description}
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.format("Player %s: %s\n", name, clazz));
        stringBuilder.append(String.format("Rank: %s\n", rank));
        stringBuilder.append(String.format("Description: %s", description));
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
