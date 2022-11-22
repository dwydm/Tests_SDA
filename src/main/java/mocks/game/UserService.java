package mocks.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
    private List<User> users;

    public UserService() {
        this.users = loadUsers();
    }

    public boolean existsByName(String name) {
        long counter = users.stream()
                .filter(user -> name.equals(user.getName()))
                .count();
        return counter == 1;
    }

    public User getUserByName(String userName) {
        return users.stream()
                .filter(user -> userName.equals(user.getName()))
                .findFirst().orElseThrow(()->new RuntimeException());
    }

    private List<User> loadUsers() {
        return new ArrayList<>(Arrays.asList(
                new User(1, "Tomasz", "ADMIN"),
                new User(2, "Robert", "ADMIN"),
                new User(3, "Jacek", "MOD")
        ));
    }
}
