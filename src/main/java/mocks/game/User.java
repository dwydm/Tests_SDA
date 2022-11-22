package mocks.game;

public class User {
    private int userId;
    private String name;
    private String rank;

    public User(int userId, String name, String rank) {
        this.userId = userId;
        this.name = name;
        this.rank = rank;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }
}
